package com.vk.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RetriveDAO {
           public ArrayList<BusBean> a1=new ArrayList<BusBean>();
           public ArrayList<BusBean> retrive(){
        	 try {
        		 Connection con=DBConnection.getCon();
        		 PreparedStatement ps=con.prepareStatement("select * from BUSSERVICE");
        		 ResultSet rs=ps.executeQuery();
        		 while(rs.next()) {
        			 BusBean bb=new BusBean();
        			 bb.setServNo(rs.getInt(1));
        			 bb.setServName(rs.getString(2));
        			 bb.setfStation(rs.getString(3));
        			 bb.settStation(rs.getString(4));
        			 bb.setdTime(rs.getString(5));
        			 bb.setaTime(rs.getString(6));
        			 bb.setSeats(rs.getInt(7));
        			 bb.setPrice(rs.getFloat(8));
        			 a1.add(bb);
        		 }
        	 }catch(Exception e ) { e.printStackTrace();}
        	   
        	   return a1;
           }
}
