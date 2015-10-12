/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author isaac
 */
public class DBConnection {
    private static Connection conn;

    public DBConnection() {
        conn = null;
        loadDriver();
        connectionDataBase();
    }     
    
    public static void loadDriver(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "Error, no se pudo conectar a la base de datos: "+e);
        }
    }
        

    public static void connectionDataBase(){
        try{
            String url = "jdbc:mysql://localhost:3306/JooglI_DB";
            String user = "root";
            String password = "";
            conn = DriverManager.getConnection(url, user, password);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error, no se pudo conectar a la base de datos: "+e);
        }
        //JOptionPane.showMessageDialog(null, "Connection successful");
    }

    public static Connection getConn() {
        return conn;
    }

    public static void setConn(Connection conn) {
        DBConnection.conn = conn;
    }        
}
