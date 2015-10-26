/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.concurrent.RunnableFuture;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import models.SearchEngine;
import models.Sites;
import models.Token;
import multicore.ParallelTasks;
import org.jsoup.Jsoup;

/**
 *
 * @author isaac
 */
public class SearchEngineController {
    private ArrayList<Sites> listSites;
    private static Connection conn;
    private static int index;
    private static int index2;
    private static int semaphore = 1;
    private static int fillCount = 0;
    private static int emptyCount = 0;
    private static boolean available = true;
    
    public boolean matchingTitleG;
    public BigInteger  timeFirstMatchPerSite,totalMatchTime;
    
    private BigInteger timeTotalSequential;
    
    public SearchEngineController(){
        conn = new SearchEngine().getConn();
        index = 0;
    }
    
    public ArrayList<Sites> search(String strSearch, boolean implementsMultiCore) throws InterruptedException{
        //time variables sequential mode        
        BigInteger timeTotalMatchPerSite, timeTotal;
        long timeStart;
        ArrayList<Sites> listMatchingTittles = new ArrayList<>();
        ArrayList<Sites> listMatchingBody = new ArrayList<>();                
        
        timeStart=System.currentTimeMillis();
        System.out.println("Time of first match "+timeStart+" milliseconds");
        long startTimeSite = System.currentTimeMillis();
        if(implementsMultiCore){  
            System.err.println("MULTI");
            index = 0;
            ParallelTasks tasks = new ParallelTasks();
            
            for(int i = 0; i < listSites.size(); i++){
                //index = i;                                
                tasks.add(new Runnable() {
                    public void run()
                    {
                        try
                        {                                                        
                            while(!available){}                            
                            available = false;                            
                            if(semaphore>0){
                                semaphore--;
                            }
                            else{
                                while(semaphore<1){}                            
                                semaphore--;
                            }
                            Sites webSite = listSites.get(index);
                            index++;
                            available = true;
                            semaphore++;
                            long startTimeSite = System.currentTimeMillis();
                            boolean matchingTitle = searchTokenParallel(webSite, strSearch);
                            if((webSite.getListTokensMatches()!=null) && (!webSite.getListTokensMatches().isEmpty())){
                                if(matchingTitle){
                                    listMatchingTittles.add(webSite);
                                }
                                else{
                                    listMatchingBody.add(webSite);                
                                }
                            }
                            BigInteger timeTotalMatchPerSite2=BigInteger.valueOf(System.currentTimeMillis());
                            timeTotalMatchPerSite2=timeTotalMatchPerSite2.subtract(BigInteger.valueOf(startTimeSite));
                            webSite.setTimeTotalMatchPerSite(timeTotalMatchPerSite2);
                            matchingTitle = false;                            

                        }
                        catch (Exception e)//Interrupted
                        {
                        }
                    }
                });
            }
            final long start = System.currentTimeMillis();
            tasks.go();
            System.err.println(System.currentTimeMillis() - start);
            setTimeTotalSequential(BigInteger.valueOf(System.currentTimeMillis()));
            setTimeTotalSequential(timeTotalSequential.subtract(BigInteger.valueOf(timeStart)));
        }
        else{      
            System.err.println("UNI");
            for(int i = 0; i < listSites.size(); i++){
                startTimeSite = System.currentTimeMillis();
                boolean matchingTitle = searchByWebSite(listSites.get(i), strSearch);
                if((listSites.get(i).getListTokensMatches()!=null) && (!listSites.get(i).getListTokensMatches().isEmpty())){
                    if(matchingTitle){
                        listMatchingTittles.add(listSites.get(i));
                    }
                    else{
                        listMatchingBody.add(listSites.get(i));                
                    }
                }
                matchingTitle = false;
                timeTotalMatchPerSite=BigInteger.valueOf(System.currentTimeMillis());
                timeTotalMatchPerSite=timeTotalMatchPerSite.subtract(BigInteger.valueOf(startTimeSite));
                listSites.get(i).setTimeTotalMatchPerSite(timeTotalMatchPerSite);
            }            
        }
        System.err.println(System.currentTimeMillis() - timeStart);    
        setTimeTotalSequential(BigInteger.valueOf(System.currentTimeMillis()));
        setTimeTotalSequential(timeTotalSequential.subtract(BigInteger.valueOf(timeStart)));                
        ArrayList<Sites> listMatching = new ArrayList<>();
        listMatching.addAll(listMatchingTittles);
        listMatching.addAll(listMatchingBody);   
        index = 0;
        return listMatching;
    }
    
    private boolean searchTokenParallel(Sites webSiteToSearch, String strSearch) throws InterruptedException{
        webSiteToSearch.setListTokensMatches(null);
        StringTokenizer tokens = new StringTokenizer(strSearch);
        ArrayList<Token> listTokensMatches = new ArrayList<Token>();
        matchingTitleG=false;
         
        ParallelTasks task= new ParallelTasks();
        long timeStart = System.currentTimeMillis();
        while(tokens.hasMoreTokens()){
         
            String token = tokens.nextToken();
            task.add(new Runnable() { 
                public void run() {
                    try{
                    long timeStartForToken = System.currentTimeMillis();
                    boolean firstMatch=false;
                    
                    int numberMatches = 0;
                    
                    String textTitle = webSiteToSearch.getTitle().toLowerCase();
                    for(int n = 0; n< textTitle.length(); n++){
                        if(textTitle.charAt(n) == token.charAt(0)){
                            int tempN = n; boolean match = true;
                            for(int m = 0; m < token.length(); m++){
                                if(textTitle.charAt(tempN) != token.charAt(m)){
                                    match = false;
                                    break;
                                }
                                tempN++;
                            }
                            if(match){
                              numberMatches++;
                              if(!firstMatch){
                                firstMatch=true;
                                timeFirstMatchPerSite=BigInteger.valueOf(System.currentTimeMillis());
                                timeFirstMatchPerSite=timeFirstMatchPerSite.subtract(BigInteger.valueOf(timeStartForToken));
                              }
                            }
                        }
                    }
                    if(numberMatches > 0){ // If found any match in the tittle, this will be prioritized
                        matchingTitleG= true;
                    }
                    String textBody = webSiteToSearch.getBody().toLowerCase();
                    for(int n = 0; n < textBody.length(); n++){
                        if(textBody.charAt(n) == token.charAt(0)){
                            int tempN = n; boolean match = true;
                            for(int m = 0; m < token.length(); m++){
                                if(textBody.charAt(tempN) != token.charAt(m)){
                                    match = false;
                                    break;
                                }
                                tempN++;
                            }
                            if(match){
                                numberMatches++;
                                if(!firstMatch){
                                    firstMatch=true;
                                    timeFirstMatchPerSite=BigInteger.valueOf(System.currentTimeMillis());
                                    timeFirstMatchPerSite=timeFirstMatchPerSite.subtract(BigInteger.valueOf(timeStartForToken));
                                }
                            }
                        }
                    }
                    if(numberMatches > 0){
                        totalMatchTime=BigInteger.valueOf(System.currentTimeMillis());
                        totalMatchTime=totalMatchTime.subtract(BigInteger.valueOf(timeStart));
                        listTokensMatches.add(new Token(token, numberMatches, timeFirstMatchPerSite, totalMatchTime));
                    }
                }
                    catch(Exception e){
                    }
                    
                }
                
            });
            
        }
        final long start = System.currentTimeMillis();
        task.go();
        System.out.println(System.currentTimeMillis() - start+" task");
        
        if(!listTokensMatches.isEmpty()){
            webSiteToSearch.setListTokensMatches(listTokensMatches);
        }
        return matchingTitleG;
        
    }
    
    private boolean searchByWebSite(Sites webSiteToSearch, String strSearch){
        boolean matchingTitle = false; boolean firstMatch=false;
        BigInteger  timeFirstMatchPerSite = BigInteger.valueOf(0); 
        BigInteger  totalMatchTime = BigInteger.valueOf(0);         
        webSiteToSearch.setListTokensMatches(null);
        StringTokenizer tokens = new StringTokenizer(strSearch);
        ArrayList<Token> listTokensMatches = new ArrayList<Token>();
        int intMatch = 0;
        Token currentToken = null;
        long timeStart = System.currentTimeMillis();
        while(tokens.hasMoreTokens()){ 
            firstMatch=false;
            long timeStartForToken = System.currentTimeMillis();
            
            int numberMatches = 0;
            String token = tokens.nextToken();
            // Compare the tokens with the title of the web-site
            String textTitle = webSiteToSearch.getTitle().toLowerCase();
            for(int n = 0; n< textTitle.length(); n++){
                if(textTitle.charAt(n) == token.charAt(0)){
                    int tempN = n; boolean match = true;
                    for(int m = 0; m < token.length(); m++){
                        if(textTitle.charAt(tempN) != token.charAt(m)){
                            match = false;
                            break;
                        }
                        tempN++;
                    }
                    if(match){
                        numberMatches++;
                        if(!firstMatch){
                            firstMatch=true;
                            //long a = System.currentTimeMillis();
                            //DecimalFormat df= new DecimalFormat("000");
                            //System.out.println("T "+a);
                            timeFirstMatchPerSite=BigInteger.valueOf(System.currentTimeMillis());
                            timeFirstMatchPerSite=timeFirstMatchPerSite.subtract(BigInteger.valueOf(timeStartForToken));
                            System.out.println("Time of first match "+timeFirstMatchPerSite+" milliseconds");
                        }
                    }
                }
            }
            if(numberMatches > 0){ // If found any match in the tittle, this will be prioritized
                matchingTitle = true;
            }

            // Compare the tokens with the body of the web-site
            String textBody = webSiteToSearch.getBody().toLowerCase();
            for(int n = 0; n < textBody.length(); n++){
                if(textBody.charAt(n) == token.charAt(0)){
                    int tempN = n; boolean match = true;
                    for(int m = 0; m < token.length(); m++){
                        if(textBody.charAt(tempN) != token.charAt(m)){
                            match = false;
                            break;
                        }
                        tempN++;
                    }
                    if(match){
                        numberMatches++;
                        if(!firstMatch){
                                firstMatch=true;
                                timeFirstMatchPerSite=BigInteger.valueOf(System.currentTimeMillis());
                                timeFirstMatchPerSite=timeFirstMatchPerSite.subtract(BigInteger.valueOf(timeStartForToken));
                              }
                    }
                }
            }
            // If exist more than zero matches of token, it added to list tokens match list
            if(numberMatches > 0){
                totalMatchTime=BigInteger.valueOf(System.currentTimeMillis());
                totalMatchTime=totalMatchTime.subtract(BigInteger.valueOf(timeStart));
                System.out.println("Time of first match "+totalMatchTime+" milliseconds");
                listTokensMatches.add(new Token(token, numberMatches, timeFirstMatchPerSite, totalMatchTime));
            }
        }
        
        
        if(!listTokensMatches.isEmpty()){
            webSiteToSearch.setListTokensMatches(listTokensMatches);
        }
        return matchingTitle;
    }
    
    public void openWebSite(String webAdress){
        if(java.awt.Desktop.isDesktopSupported()){
            try{
                 Desktop dk = Desktop.getDesktop();
                 dk.browse(new URI(webAdress));
            }catch(Exception e){
                System.out.println("Error al abrir URL: "+e.getMessage());
            }
        }  
    }
    
    public ArrayList<Sites> consultSites(){
        try{
             listSites = new Sites().consultSites(conn);
             for(int i = 0; i < listSites.size(); i++){                 
                 //String tempURL="http://billyprogramador.blogspot.com/2011/11/como-alterar-el-resultado-de-una.html";
                 String result = listSites.get(i).getHTMLContent();
                 listSites.get(i).setBody(Jsoup.parse(result).text());
             }
        }
        catch(Exception e){
        
        }
        return listSites;
    }       
    
    public void printSites(ArrayList<Sites> listSites){
        if(listSites.size() == 0){
            System.out.println("¡No se encontraron coincidencias!");
            return ;
        }
        for(int i = 0; i < listSites.size(); i++){
            System.out.println("Site: " + listSites.get(i).getTitle());
            System.out.println("Address: " + listSites.get(i).getAddress());
            System.out.println("Body: " + listSites.get(i).getBody());
        }
    }

    public ArrayList<Sites> getListSites() {
        return listSites;
    }

    public void setListSites(ArrayList<Sites> listSites) {
        this.listSites = listSites;
    }

    public static Connection getConn() {
        return conn;
    }

    public static void setConn(Connection conn) {
        SearchEngineController.conn = conn;
    }

    public BigInteger getTimeTotalSequential() {
        return timeTotalSequential;
    }

    public void setTimeTotalSequential(BigInteger timeTotalSequential) {
        this.timeTotalSequential = timeTotalSequential;
    }
    
    
    
    
}
