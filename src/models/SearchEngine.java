/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import database.DBConnection;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author isaac
 */
public class SearchEngine {
    private String search;
    private Connection conn;
    
    public SearchEngine(){
        conn = new DBConnection().getConn();
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
        

    public SearchEngine(String search) {
        this.search = search;
    }
            
    public ArrayList<Sites> search(){
        return null;
    }
}
