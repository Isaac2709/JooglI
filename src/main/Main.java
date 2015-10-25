/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controllers.SearchEngineController;
import database.DBConnection;
import java.sql.Connection;
import models.Sites;
import multicore.ParallelTasks;
import org.jsoup.Jsoup;

/**
 *
 * @author isaac
 */
public class Main {
    private static SearchEngineController searchEngine = new SearchEngineController();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        // TODO code application logic here
        
//        try{
//            String result = new SearchEngineController().getContenidoHTML("http://facebook.com");            
//            new SearchEngineController().openWebSite();
//            System.out.println(result); 
//        }catch(Exception e){System.err.println("E: " + e);}
        searchEngine.consultSites();
        views.SearchEngineView mainView = new views.SearchEngineView(searchEngine);
        mainView.setVisible(true);
        //views.SitesView sitesView = new views.SitesView(searchEngine);
        //sitesView.setVisible(true);
        //try{
            //String result = new SearchEngineController().getContenidoHTML("http://billyprogramador.blogspot.com/2011/11/como-alterar-el-resultado-de-una.html");
            
            //System.out.println(Jsoup.parse(result).text()); 
            //Connection conn = new DBConnection().getConn();
            //Sites google = new Sites("BillyProgramador", "http://billyprogramador.blogspot.com/2011/11/como-alterar-el-resultado-de-una.html", null, null, null, null, null, null);
            //google.registerSite(conn);
        //}
        //catch(Exception e){
        
        //}
    }
    
}
