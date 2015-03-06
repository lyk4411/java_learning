package com.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.action.CreateNewsAction;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("*.do")
public class ControllerServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uri = request.getRequestURI();
		int pos1 = uri.indexOf(".do");
		int pos2 = uri.lastIndexOf("/");
		
		String action = uri.substring(pos1+1,pos2);
		
		if(action.equals("createnews")){
			CreateNewsAction act = new CreateNewsAction();
			RequestDispatcher dis = act.execute(request, response);
			dis.forward(request, response);
		}
		else if(action.equals("removenews")){
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
