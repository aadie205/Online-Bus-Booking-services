package com.vk.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;

import oracle.net.aso.e;

public class RegisterDAO {
    
	    public int k;
	    
	    public int insert(RegBean rb ) {
	    	
	    	try {
	    		System.out.println("In RegisteerDAO()");
	    		Connection con=DBConnection.getCon();
	    		PreparedStatement ps=con.prepareStatement
	    				("insert into usertable values(?,?,?,?,?,?,?)");
	    		ps.setString(1, rb.getuName());
	    		ps.setString(2, rb.getpWd());
	    		ps.setString(3, rb.getfName());
	    		ps.setString(4, rb.getlName());
	    		ps.setString(5, rb.getAddr());
	    		ps.setLong(6, rb.getPhNo());
	    		ps.setString(7, rb.getmId());
	    		
	    		k=ps.executeUpdate();
	    		System.out.println("K value in insert(): "+k);
	    	}catch(Exception e) { e.printStackTrace();}
	    	
	    	 return k;
	    }//insert
}
