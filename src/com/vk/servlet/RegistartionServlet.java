package com.vk.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistartionServlet extends HttpServlet {
    public ServletContext sct;
    public RegBean  rb;
     @Override
    public void init() throws ServletException {
    	sct=this.getServletContext();
    	rb=new RegBean();
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	    
    	rb.setuName(req.getParameter("uname"));
    	rb.setpWd(req.getParameter("pwd"));
    	rb.setfName(req.getParameter("fname"));
    	rb.setlName(req.getParameter("lname"));
    	rb.setAddr(req.getParameter("addr"));
    	rb.setPhNo(Long.parseLong(req.getParameter("phno")));
    	rb.setmId(req.getParameter("mid"));
    	System.out.println("Input values set to RegBean");
    	
    	PrintWriter pw=res.getWriter();
    	res.setContentType("text/html");
    	
    	if(new RegisterDAO().insert(rb)>0) {
    		//System.out.println("in if condition");   		
    	    pw.print("<br>User registration sucessful..!");
    	    RequestDispatcher rd=req.getRequestDispatcher("Login.html");
    	    rd.include(req, res);
    	    
    	}
    }//doPost
	
}//RegistrationServlet
