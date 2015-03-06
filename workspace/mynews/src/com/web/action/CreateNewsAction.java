package com.web.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateNewsAction {
	public RequestDispatcher execute(HttpServletRequest request, HttpServletResponse res){
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		request.setAttribute("info", "create news[" + title + "] successfully!");
		return request.getRequestDispatcher("show.jsp");
		
	}
}
