/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Devangkumar
 */
public class DatabaseConnection {
   Connection con = null;
   ResultSet rs=null;
    public ResultSet getResultset()
   {
          Connection con = null;
            ResultSet rs=null;
       try {
         
            
             con = DriverManager.getConnection("jdbc:derby://localhost:1527/OnlineShopping");
             java.sql.Statement sta = con.createStatement(); 

             rs=sta.executeQuery("SELECT * FROM USER_DETAILS");
        } catch (Exception e) {
       }   
 return rs;      
   }
    
    public int insertUser(String name,String email,String password)
    {
        int c=0;
        try {
        java.sql.Statement sta = con.createStatement(); 
       
          c= sta.executeUpdate("INSERT INTO APP.USER_DETAILS"+" VALUES ('"+name+"', '"+email+"', '"+password+"')");
       } catch (SQLException ex) {
           Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
       }
    return c;
    }
}
