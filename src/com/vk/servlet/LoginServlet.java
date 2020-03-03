package com.vk.servlet;
import javax.servlet.*;
import java.io.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet	{
   
	public ServletContext sct;
	public void init()throws ServletException{
		sct=this.getServletContext();
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    String sub=req.getParameter("sub");
	    sct.setAttribute("sub",sub);
	    
	   // System.out.println("sub value from sct"+sct.getAttribute("sub"));
	    
	    if(sub.equals("AdminLogin")) {	    	
	    	RequestDispatcher rd=req.getRequestDispatcher("ALogin.html");
	    	rd.forward(req, res);
	    	
	    }else {
	    	//System.out.println("UserLogin");
	    	RequestDispatcher rd=req.getRequestDispatcher("ULogin.html");
	    	rd.forward(req, res);
	    }
	
	}
}
