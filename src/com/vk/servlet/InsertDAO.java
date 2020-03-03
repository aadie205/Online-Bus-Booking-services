package com.vk.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertDAO {
         public int k;
         
         public int insert(BusBean bb) {
        	 try {
        		 Connection con=DBConnection.getCon();
        		 PreparedStatement ps=con.prepareStatement("insert into BUSSERVICE values(?,?,?,?,?,?,?,?)");
        		 ps.setInt(1, bb.getServNo());
        		 ps.setString(2,bb.getServName());
        		 ps.setString(3,bb.getfStation());
        		 ps.setString(4,bb.gettStation());
        		 ps.setString(5,bb.getdTime());
        		 ps.setString(6,bb.getaTime());
        		 ps.setInt(7,bb.getSeats());
          		 ps.setFloat(8,bb.getPrice());
          		 k=ps.executeUpdate();
        		 
        	 }catch(Exception e ) {e.printStackTrace();}
        	// System.out.println("k value in InsertDAO.inert : "+k);
        	 return k;
         }
}
