/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

    public Sites() {
    }

    public Sites(String title, String address, String languaje, ArrayList<String> listTags, String header, String body, String footer) {
        this.title = title;
        this.address = address;
        this.languaje = languaje;
        this.listTags = listTags;
        this.header = header;
        this.body = body;
        this.footer = footer;
    }
    
    public void registerSite(Connection conn){
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
            JOptionPane.showMessageDialog(null, "Error while trying to register a new web-site: " + e.getMessage());
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
    
    
}
