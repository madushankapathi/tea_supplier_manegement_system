/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author Madushanka
 */
public class DBMS {
    
    
    private final static String url = "jdbc:mysql://localhost:3306/tea?allowPublicKeyRetrieval=true&useSSL=false";
    private final static String username = "root";
    private final static String password = "7605";
    private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static Connection c;
    
    
    public static synchronized Connection getConnection (){
    
        try {
            
            if(c==null){
            Class.forName(DRIVER);
            c= DriverManager.getConnection(url,username,password);
            }
            
            
        } catch (Exception e) {
            System.out.println(e);
        }
        return c;
    }
    
    public static void iud(String query){
    
        try {
            
            getConnection().createStatement().executeUpdate(query);
            
        } catch (Exception e) {
            System.out.println(e);
        }
    
    }
    
    
    
    public static ResultSet search(String query){
    
        ResultSet rs = null;
        
        try {
            
          rs =  (ResultSet) getConnection().createStatement().executeQuery(query);
            
        } catch (Exception e) {
            
            System.out.println(e);
        }
    return rs;
    }
}
