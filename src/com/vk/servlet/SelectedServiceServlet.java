package com.vk.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

@SuppressWarnings("serial")
public class SelectedServiceServlet extends HttpServlet{
                 @Override
                protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
                	PrintWriter pw=res.getWriter();
                	res.setContentType("text/html");
                	
             		//System.out.println("In SelectedServiceServlet - before if condition");
                	
                	Cookie c[]=req.getCookies();
                	if(c==null) {
                		pw.print("Please login first..!");
                		RequestDispatcher rd=req.getRequestDispatcher("Login.html");
                		rd.include(req, res);
                	}else {
                		
                		//System.out.println("In SelectedServiceServlet - else block ");
                		String fName=c[0].getValue();
                		pw.print("Welcome : "+fName+"<br>");
                		RequestDispatcher rd=req.getRequestDispatcher("Link2.html");
                		rd.include(req, res);
                		
                		int sNo=Integer.parseInt(req.getParameter("sno"));
                		ServletContext sct=this.getServletContext();
                		ArrayList<BusBean> al=(ArrayList<BusBean>)sct.getAttribute("jcfRef");
                		//System.out.println("before line no 43");
                		java.util.List<BusBean> l=al.stream().filter((k)->k.getServNo()==sNo).collect(Collectors.toList());
            
                		l.forEach((z)->
                		{
                			BusBean bb=(BusBean)z;
                			pw.print("<br>"+bb.getServNo()+"&nbsp&nbsp"
         				           +bb.getServName()+"&nbsp&nbsp"
         						   +bb.getfStation()+"&nbsp&nbsp"
         						   +bb.gettStation()+"&nbsp&nbsp"
         						   +bb.getdTime()+"&nbsp&nbsp"
         						   +bb.getaTime()+"&nbsp&nbsp"
         						   +bb.getSeats()+"&nbsp&nbsp"
         						   +bb.getPrice()+"&nbsp&nbsp");
                		});
                		pw.print("&nbsp&nbsp<a href ='book'>Book Ticket</a>");
                		
                	}
                }
}
