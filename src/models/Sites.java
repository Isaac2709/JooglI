/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author isaac
 */
public class Sites {
    private String title;
    private String address;
    private String languaje;
    private ArrayList<String> listTags;
    private String header;
    private String body;
    private String footer;
    private String summary;
    private ArrayList<Token> listTokensMatches;
    private BigInteger timeTotalMatchPerSite;

    public Sites() {
    }
    
    public Sites(String title, String address) {
        this.title = title;
        this.address = address;
    }
    
    public boolean registerSite(Connection conn){
        String sql_query;
        PreparedStatement ps;
        try{
            sql_query = "insert into sites values (null,?, ?)";
            ps = conn.prepareStatement(sql_query);                        
            ps.setString(1, this.title);
            ps.setString(2, this.address);            
            ps.executeUpdate();
        }
        catch(SQLException e){
            //JOptionPane.showMessageDialog(null, "Error while trying to register a new web-site: " + e.getMessage());
            System.out.print("Error while trying to register a new web-site: " + e.getMessage());
            return false;
        }
        return true;
    }
    
    public ArrayList<Sites> consultSites(Connection conn){
        String sql_query = "select * from sites";
        ArrayList<Sites> listSites = new ArrayList<Sites>();
        try{
            PreparedStatement ps = conn.prepareStatement(sql_query);
            ResultSet res = ps.executeQuery();
            Sites tempSite;
            for(int i = 0; res.next(); i++){
                tempSite =  new Sites(res.getString(2), res.getString(3));
                listSites.add(tempSite);                
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error while trying to register a new web-site: " + e.getMessage());
        }
        return listSites;
    }
    
    public String getHTMLContent() throws IOException {
        String strURL = this.address;
        URL url = new URL(strURL);
        URLConnection uc = url.openConnection();
        uc.connect();
        //Creamos el objeto con el que vamos a leer
        BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
        String inputLine;
        String contenido = "";
        while ((inputLine = in.readLine()) != null) {
            contenido += inputLine + "\n";
        }
        in.close();
        return contenido;
    }
    
    public String obtenerCodigoFuente()
    {
        URL urlpagina = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        String linea;
        StringBuffer buffer = new StringBuffer();

        try {
            urlpagina = new URL(this.address);
            isr = new InputStreamReader(urlpagina.openStream());
            br = new BufferedReader(isr);
            while ((linea = br.readLine()) != null){
                buffer.append(linea);
            }
            br.close();
            isr.close();
        } catch (MalformedURLException e) {
            JOptionPane.showMessageDialog(null, "Error en la url, ejemplo http://www.ejemplo.com");
            return null;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo");
            return null;
        }
        return buffer.toString();
    }
    
    public String getTitleFromSource() throws IOException {
        String content = obtenerCodigoFuente();
        if(content == null){
            return null;
        }
        String title="";                     
        
        int indexStart = content.indexOf ("<title>");
        int indexEnd = content.indexOf ("</title>");
        if (indexStart != -1 && indexEnd != -1){
            title = content.substring(indexStart+7, indexEnd);        
        }            
        return title;
    }
    
    public boolean existURL(){
        URL url = null;
        try {
            url = new URL(this.address);
            return true;
        } 
        catch (MalformedURLException e) {                     
            return false;
        }
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }        

    public String getLanguaje() {
        return languaje;
    }

    public void setLanguaje(String languaje) {
        this.languaje = languaje;
    }

    public ArrayList<String> getListTags() {
        return listTags;
    }

    public void setListTags(ArrayList<String> listTags) {
        this.listTags = listTags;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public ArrayList<Token> getListTokensMatches() {
        return listTokensMatches;
    }

    public void setListTokensMatches(ArrayList<Token> listTokensMatches) {
        this.listTokensMatches = listTokensMatches;
    }        

    public BigInteger getTimeTotalMatchPerSite() {
        return timeTotalMatchPerSite;
    }

    public void setTimeTotalMatchPerSite(BigInteger timeTotalMatchPerSite) {
        this.timeTotalMatchPerSite = timeTotalMatchPerSite;
    }
}
