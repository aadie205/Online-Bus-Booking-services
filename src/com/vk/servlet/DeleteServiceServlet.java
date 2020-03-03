package com.vk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteServiceServlet extends HttpServlet {
         
	   @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    	  PrintWriter pw=res.getWriter();
	    	  res.setContentType("text/html");
	    	  Cookie c[]=req.getCookies();
	    	  //System.out.println("In ViewServicesServlet1");
	    	  if(c==null) {
	    		  pw.print("Please login first..!<br>");
	    		  RequestDispatcher rd=req.getRequestDispatcher("Link.html");
	    		  rd.include(req, res);
	    	  }else { 
	    		  ArrayList<BusBean> al= new RetriveDAO().retrive();
	    		  //System.out.println("In ViewServicesServlet1 al: "+al);
	    		  if(al.size()==0) {
	    			  pw.print("<br>No Services available to Delete. Please add a service...! <br><br>");
	    			  RequestDispatcher rd=req.getRequestDispatcher("Link.html");
					  rd.include(req, res);
	    		  }else {
	    			  
	    			  RequestDispatcher rd=req.getRequestDispatcher("Link.html");
					  rd.include(req, res);
					  pw.print("<br><br><br><br>Please select service no to delete :<br>");
					  pw.print("----------------------------------------------------");
	    			  al.forEach((k)->
	    			  { 
	    				  
	    				 
	    				  //System.out.println("In ViewServicesServlet1 else block ");
	    				 BusBean bb=(BusBean)k;
	    				 //System.out.println("else block before BusBean");
	    				 
	    				 pw.print("<br><a href='deleteService?sno="+bb.getServNo()+"'>"+bb.getServNo()+"</a>"+"&nbsp&nbsp");
	    				 pw.print("&nbsp&nbsp"+bb.getServName()+"&nbsp&nbsp"
	    						   +bb.getfStation()+"&nbsp&nbsp"
	    						   +bb.gettStation()+"&nbsp&nbsp"
	    						   +bb.getdTime()+"&nbsp&nbsp"
	    						   +bb.getaTime()+"&nbsp&nbsp"
	    						   +bb.getSeats()+"&nbsp&nbsp"
	    						   +bb.getPrice()+"&nbsp&nbsp");
	    				 
	    			  });
	    		  }
	    	  }
	    }
	}

