package com.vk.servlet;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
       private DBConnection() {}
       private static Connection con;
       static {
    	   try {
    		   Class.forName("oracle.jdbc.driver.OracleDriver");
    		   con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott","tiger");
    		   
    	   }catch(Exception e) {e.printStackTrace();}
    	   
       }
       public static Connection getCon() {
    	   return con;
       }
}
