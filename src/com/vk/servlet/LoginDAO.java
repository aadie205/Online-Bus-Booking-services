package com.vk.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;


public class LoginDAO {
       public boolean z;
       public boolean login(HttpServletRequest req, ServletContext sct) {
    	   try {
    		   Connection con=DBConnection.getCon();
    		   String sub=(String)sct.getAttribute("sub");
    	 
    		   if(sub.equals("AdminLogin")) {
    			   //System.out.println("Admin Login");
    			   PreparedStatement ps=con.prepareStatement("select * from admintable where uname=? and pwd=?");
                   //System.out.println("prepared statement object : "+ps);
    			   ps.setString(1, req.getParameter("uname"));
    			   ps.setString(2, req.getParameter("pwd"));
    			   ResultSet rs=ps.executeQuery();
    			   //System.out.println("Result set : "+rs);
    			   if(rs.next()) {
    				   //System.out.println("In If block (rs.next())");
    				   z=true;
    				   sct.setAttribute("fName", rs.getString(3));
    			   }
    		   }else {
    			  // System.out.println("User Login ");
    			   PreparedStatement ps=con.prepareStatement("select * from usertable where uname=? and pwd=?");
    			   ps.setString(1, req.getParameter("uname"));
    			   ps.setString(2, req.getParameter("pwd"));
    			   
    			  // System.out.println("prepared statement object : "+ps);
    			   
    			   ResultSet rs=ps.executeQuery();
    			  // System.out.println("Result set : "+rs);
    			   if(rs.next()) {
    				   //System.out.println("In If block (rs.next())");
    				   z=true;
    				   sct.setAttribute("fName", rs.getString(3));
    				   
    			   }
    	   
    		   }
    		   
    	   }catch(Exception e ) {e.printStackTrace();}
    	  //System.out.println("Return value Z"+z);		
    	   return z;
       }
}
