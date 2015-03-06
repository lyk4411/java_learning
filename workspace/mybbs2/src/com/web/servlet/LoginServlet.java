package com.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		response.setContentType("text/html"); 
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		if(username.equals("123") && password.equals("123")){
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			
			Cookie cu = new Cookie("username",username);
			cu.setMaxAge(1000000);
			Cookie cp = new Cookie("password",password);
			cp.setMaxAge(1000000);
			
			response.addCookie(cu);
			response.addCookie(cp);
			
			out.println("<html><head><title>success</title></head><body>");
			out.println("<h1>gongxi</h1>");
			out.println("</body></html>");
		}
		else {
			out.println("<html><head><title>failed</title></head><body>");
			out.println("<h1>sorry,you are wrong!</h1>");
			out.println("</body></html>");
		}
	}
}
