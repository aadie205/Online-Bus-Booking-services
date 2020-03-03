package com.vk.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletContext;

public class UpdateDAO {
	 public int k;
	 public int update(BusBean bb,ServletContext sct) {
   	  try {
   		  int sNo=(Integer)sct.getAttribute("servNo");
   		  Connection con=DBConnection.getCon();
   PreparedStatement ps=con.prepareStatement
("update BUSSERVICE set SERVICENO=?,SERVICENAME=?,FSTATION=?,TSTATION=?,DTIME=?,ATIME=?,SEATS=?,PRICE=? where serviceno=?");
     ps.setInt(1, bb.getServNo());
	 ps.setString(2,bb.getServName());
	 ps.setString(3,bb.getfStation());
	 ps.setString(4,bb.gettStation());
	 ps.setString(5,bb.getdTime());
	 ps.setString(6,bb.getaTime());
	 ps.setInt(7,bb.getSeats());
	 ps.setFloat(8,bb.getPrice());
	 ps.setInt(9,sNo);
	 
	 k=ps.executeUpdate();
	 
}catch(Exception e ) {e.printStackTrace();}
// System.out.println("k value in InsertDAO.inert : "+k);
 return k;
}
}