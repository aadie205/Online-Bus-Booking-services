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
public class LogoutServlet extends HttpServlet {
            @Override
            protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
            	PrintWriter pw=res.getWriter();
            	res.setContentType("text/html");
            	Cookie c[]=req.getCookies();
            	c[0].setValue(" ");
            	c[0].setMaxAge(0);
            	pw.print("Logout successfully..!");
            	RequestDispatcher rd=req.getRequestDispatcher("Login.html");
            	rd.include(req, res);
            }
}
