package com.vk.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class RetriveDAO2 {
        
	  public ArrayList<BusBean> al=new ArrayList<BusBean>();
	  
	  public ArrayList<BusBean> retirve(HttpServletRequest req){
		  try {
			  Connection con=DBConnection.getCon();
			  PreparedStatement ps=con.prepareStatement("select * from BUSSERVICE where fstation=? and tstation=?");
			  ps.setString(1, req.getParameter("fstation"));
			  ps.setString(2, req.getParameter("tstation"));
			  ResultSet rs=ps.executeQuery();
	//System.out.println("In RetiveDAO2");
	
			  while(rs.next()) {
	//System.out.println("In RetiveDAO2- While loop");
				  BusBean bb=new BusBean();
	//System.out.println("BusBean object : "+bb);
				  bb.setServNo(rs.getInt(1));
				  bb.setServName(rs.getString(2));
				  bb.setfStation(rs.getString(3));
				  bb.settStation(rs.getString(4));
				  bb.setdTime(rs.getString(5));
				  bb.setaTime(rs.getString(6));
				  bb.setSeats(rs.getInt(7));
				  bb.setPrice(rs.getFloat(8));
				  
				  al.add(bb);
				
				  
			  }
			  
		  }catch(Exception e ) {e.printStackTrace();}
		  //System.out.println("al value in RetriveDAO2"+al);
	    return al;
	  }
	  
}
