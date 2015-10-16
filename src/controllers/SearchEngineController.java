/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import models.SearchEngine;
import models.Sites;
import org.jsoup.Jsoup;

/**
 *
 * @author isaac
 */
public class SearchEngineController {
    private ArrayList<Sites> listSites;
    private static Connection conn;
    
    public SearchEngineController(){
        conn = new SearchEngine().getConn();
    }
    
    public ArrayList<Sites> search(String strSearch){
        ArrayList<Sites> listMatchingTittles = new ArrayList<>();
        ArrayList<Sites> listMatchingBody = new ArrayList<>();
        for(int i = 0; i < listSites.size(); i++){
            Pattern regPatt = Pattern.compile(strSearch.toLowerCase());
            Matcher regMatch = regPatt.matcher(listSites.get(i).getTitle().toLowerCase());            
            int intMatch = 0;
            while(regMatch.find())
            {
                intMatch++;                
            }
            if(intMatch > 0){
                //String match = regMatch.group();
                System.out.println("Match "+ strSearch + " in title: " + listSites.get(i).getTitle());
                listMatchingTittles.add(listSites.get(i));
            }
            else{
                regMatch = regPatt.matcher(listSites.get(i).getBody());            
                intMatch = 0;
                while(regMatch.find())
                {
                    //String match = regMatch.group();
                    //System.out.println("Match "+ strSearch + " in body: " + match);
                    intMatch++;                
                }
                if(intMatch > 0){                                
                    listMatchingBody.add(listSites.get(i));
                }   
            }            
        }
        ArrayList<Sites> listMatching = new ArrayList<>();
        listMatching.addAll(listMatchingTittles);
        listMatching.addAll(listMatchingBody);        
        return listMatching;
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
}
