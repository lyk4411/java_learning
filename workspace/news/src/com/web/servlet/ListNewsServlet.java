package com.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ListNewsServlet
 */
@WebServlet("/listnews.html")
public class ListNewsServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListNewsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//login databases
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.write("<html><head><title>news list </title></head><body>");
		out.write("news list:<br />");
		out.write("<table border='1'><tr><td>title</td>"
				+ "<td>content</td><td>create_time</td></tr>");
		
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			//String url =  "jdbc:mysql://localhost:3306/newsdb";
			//String user = "root";
			//String password = "123456";
			//Connection con = DriverManager.getConnection(url,user,password);
			
			InitialContext ctx = new InitialContext();
			DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/newsdb");
			
			Connection con = ds.getConnection();
			
			Statement sta = con.createStatement();
			ResultSet rs = sta.executeQuery("select * from news");
			
			while(rs.next()) {
				
				out.write("<tr>");
				out.write("<td>" + rs.getString("title") +"</td>");
				out.write("<td>" + rs.getString("content") +"</td>");
				out.write("<td>" + rs.getString("create_time") +"</td>");
				out.write("</tr>");
				
			}
			rs.close();
			sta.close();
			con.close();
		} 
 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.write("</table>");
		out.write("</body></html>");
	}//24'
}
