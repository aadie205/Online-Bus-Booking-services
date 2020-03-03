package com.vk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class AddServiceServlet extends HttpServlet {
	
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	PrintWriter pw=res.getWriter();
    	res.setContentType("text/html");
    	Cookie c[]=req.getCookies();
    	if(c==null) {
    		pw.print("Please Login first!...<br>");
    		RequestDispatcher rd=req.getRequestDispatcher("Login.html");
    		rd.include(req, res);
    	}else {
    		String fName=c[0].getValue();
    		pw.print("Welcome Admin : "+fName+"<br>");
    		RequestDispatcher rd=req.getRequestDispatcher("Link.html");
    		rd.include(req, res);
    		BusBean bb=new BusBean();
    		bb.setServNo(Integer.parseInt(req.getParameter("sno")));
    		bb.setServName(req.getParameter("sname"));
    		bb.setfStation(req.getParameter("fstation"));
    		bb.settStation(req.getParameter("tstation"));
    		bb.setaTime(req.getParameter("atime"));
    		bb.setdTime(req.getParameter("dtime"));
    		bb.setSeats(Integer.parseInt(req.getParameter("seats")));
    		bb.setPrice(Float.parseFloat(req.getParameter("price")));
    		
    		//System.out.println("In AddServiceServlet : before insertDAO");
    		//System.out.println("checking BusBean  "+bb.getServName());
    		
    		if(new InsertDAO().insert(bb)>0) {
    			//System.out.println("In  AddServiceServlet : after insertDAO");
    			pw.print("<br><br><br>Bus Services added successfully!...");
    			
    		}else
    			pw.print("<br><br><br>Bus Services not added!...");
    		
    	}
    	
			
		
    }	

}
