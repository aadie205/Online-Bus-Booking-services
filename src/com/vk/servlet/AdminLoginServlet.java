package com.vk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class AdminLoginServlet extends HttpServlet	{
	
	public ServletContext sct;
	
	@Override
	public void init() throws ServletException {
	    sct=this.getServletContext();
	   // System.out.println("In init()User log in");
	   // System.out.println(sct.getAttribute("sub")); 
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
 //System.out.println("In AdminLoginServlet");	
 //System.out.println("ServletContext  sct value : "+sct);		

		if(new LoginDAO().login(req, sct)) {
 //System.out.println("In AdminLoginServlet - in if block");				
			String fName=(String)sct.getAttribute("fName");
			Cookie ck=new Cookie("fName",fName);
			res.addCookie(ck);
			sct.removeAttribute("fName");
			pw.print("Welcome ADMIN : "+fName+"<br>");
			RequestDispatcher rd=req.getRequestDispatcher("Link.html");
			rd.include(req, res);
		}
	}

}
