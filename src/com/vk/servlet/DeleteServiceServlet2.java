package com.vk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteServiceServlet2 extends HttpServlet {

	 @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    	PrintWriter pw=res.getWriter();
	    	res.setContentType("text/html");
	    	Cookie c[]=req.getCookies();
	    	if(c==null) {
	    		pw.print("Please Login first!...<br>");
	    		RequestDispatcher rd=req.getRequestDispatcher("Login.html");
	    		rd.include(req, res);
	    	}else {
	    		
	    		RequestDispatcher rd=req.getRequestDispatcher("Link.html");
	    		rd.include(req, res);
	    		
	    		BusBean bb=new BusBean();
	    		
	    		bb.setServNo(Integer.parseInt(req.getParameter("sno")));
	    		
	    		//System.out.println("In AddServiceServlet : before insertDAO");
	    		//System.out.println("checking BusBean  "+bb.getServName());
	    		
	    		if(new DeleteDAO().delete(bb)>0) {
	    			//System.out.println("In  AddServiceServlet : after insertDAO");
	    			pw.print("<br><br>Bus Services deleted successfully!...");
	    			
	    		}else
	    			pw.print("<br><br>Unable to delete service, try again..!");
	    		
	    	}			
	    }	
	}

