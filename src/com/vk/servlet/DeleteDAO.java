package com.vk.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteDAO {


	 public int k;
	 public int delete(BusBean bb) {
   	  try {
   		  
   		  Connection con=DBConnection.getCon();
   PreparedStatement ps=con.prepareStatement
          ("delete from BUSSERVICE where serviceno=?");
     ps.setInt(1, bb.getServNo());
	 
	 k=ps.executeUpdate();
	 
}catch(Exception e ) {e.printStackTrace();}
// System.out.println("k value in InsertDAO.inert : "+k);
return k;
}
}