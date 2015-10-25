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
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.StringTokenizer;
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
    
    public SearchEngineController(){
        conn = new SearchEngine().getConn();
        index = 0;
    }
    
    public ArrayList<Sites> search(String strSearch, boolean implementsMultiCore) throws InterruptedException{
        ArrayList<Sites> listMatchingTittles = new ArrayList<>();
        ArrayList<Sites> listMatchingBody = new ArrayList<>();                
        
        if(implementsMultiCore){                
            index = 0;
            ParallelTasks tasks = new ParallelTasks();
            final Runnable waitOneSecond = new Runnable() {
                public void run()
                {
                    try
                    {                        
                        boolean matchingTitle = searchByWebSite(listSites.get(index), strSearch);
                        if((listSites.get(index).getListTokensMatches()!=null) && (!listSites.get(index).getListTokensMatches().isEmpty())){
                            if(matchingTitle){
                                listMatchingTittles.add(listSites.get(index));
                            }
                            else{
                                listMatchingBody.add(listSites.get(index));                
                            }
                        }
                        matchingTitle = false;
                        //Thread.sleep(1000);

                    }
                    catch (Exception e)//Interrupted
                    {
                    }
                }
            };
            for(int i = 0; i < listSites.size(); i++){
                //index = i;                
                System.out.println("1Index " + index);
                tasks.add(new Runnable() {
                    public void run()
                    {
                        try
                        {                             
                            boolean matchingTitle = searchByWebSite(listSites.get(index), strSearch);
                            if((listSites.get(index).getListTokensMatches()!=null) && (!listSites.get(index).getListTokensMatches().isEmpty())){
                                if(matchingTitle){
                                    listMatchingTittles.add(listSites.get(index));
                                }
                                else{
                                    listMatchingBody.add(listSites.get(index));                
                                }
                            }
                            matchingTitle = false;
                            index++;
                            //Thread.sleep(10);

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
        }
        else{        
            final long start = System.currentTimeMillis();
            for(int i = 0; i < listSites.size(); i++){
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
            }
            System.err.println(System.currentTimeMillis() - start);
        }
        ArrayList<Sites> listMatching = new ArrayList<>();
        listMatching.addAll(listMatchingTittles);
        listMatching.addAll(listMatchingBody);        
        return listMatching;
    }
    
    private boolean searchByWebSite(Sites webSiteToSearch, String strSearch){
        boolean matchingTitle = false;
        webSiteToSearch.setListTokensMatches(null);
        StringTokenizer tokens = new StringTokenizer(strSearch);
        ArrayList<Token> listTokensMatches = new ArrayList<Token>();
        int intMatch = 0;
        Token currentToken = null;
        while(tokens.hasMoreTokens()){                
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
                    }
                }
            }
            // If exist more than zero matches of token, it added to list tokens match list
            if(numberMatches > 0){
                listTokensMatches.add(new Token(token, numberMatches));
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
    
    
}
