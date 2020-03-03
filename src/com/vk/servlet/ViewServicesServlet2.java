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

@SuppressWarnings("serial")
public class ViewServicesServlet2 extends HttpServlet{
      @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	  PrintWriter pw=res.getWriter();
    	  res.setContentType("text/html");
    	  Cookie c[]=req.getCookies();
    	  
    //System.out.println("In ViewServicesServlet2");
    	  
    	  if(c==null) {
    		  pw.print("Please Login first!..<br>");
    		  RequestDispatcher rd=req.getRequestDispatcher("Link1.html");
    		  rd.include(req, res);
    	  }else {
    		  String fName=c[0].getValue();
    		  pw.print("Welcome user : "+fName+"<br>");
    		  RequestDispatcher rd=req.getRequestDispatcher("Link2.html");
    		  rd.include(req, res);
    		  ArrayList<BusBean> al=new RetriveDAO2().retirve(req);
    		  //System.out.println(al);
    		  if(al.size()==0) {
     //System.out.println(al);			  
     //System.out.println("ArrayList is empty");
    			  pw.print("<br><br>Sorry, No Services available!");
    			  
    		    }else {
    		    	
    		       this.getServletContext().setAttribute("jcfRef", al);
    		       al.forEach((k)->
    		       {
    		    	   //System.out.println("ArrayList is not empty ");
    		    	   BusBean bb=(BusBean)k;
    		    	   //System.out.println(bb);
    		    	   pw.print("<br><br>");
    		    	   
    		    	   pw.print("<br><br><a href='select?sno="+bb.getServNo()+"'>"+bb.getServNo()+"</a>");
    		    	   pw.print("&nbsp&nbsp"+bb.getServName());
    		       });
    		    }
    		  
    	  }
    }
}
