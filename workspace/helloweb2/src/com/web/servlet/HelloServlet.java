package com.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class HelloServlet extends GenericServlet {
	private int min;
	private int max;
	
	public void init(ServletConfig sc){
		min = Integer.parseInt(sc.getInitParameter("min"));
		max = Integer.parseInt(sc.getInitParameter("max"));
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html");
		res.setCharacterEncoding("UTF-8");
		
		PrintWriter out = res.getWriter();
		
		out.println("<html><head><title>hello servlet</title></head>");
		out.println("<body><h1>");
		out.println((int)(Math.random() * (max - min + 1)) + min + "<br />");
		
		HttpServletRequest hreq = (HttpServletRequest) req;
		hreq.setCharacterEncoding("UTF-8");
		String name = hreq.getParameter("name");
		String pass = hreq.getParameter("pass");
		out.println(name + ": " + pass + "<br />");
		/*
		Enumeration ee = hreq.getHeaderNames();
		while(ee.hasMoreElements()){
			String name = (String)ee.nextElement();
			String value = hreq.getHeader(name);
			
			out.println(name + " = " + value + "<br />");
		}
		*/
		out.println("</body></h1></html>");
	}
}
