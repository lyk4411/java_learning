package com.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.util.ConnectionPool;

public class AppListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sc) {
		// TODO Auto-generated method stub
		try{
			ConnectionPool cp = (ConnectionPool)sc.getServletContext().getAttribute("cp");
			if(cp != null){
				cp.destroy();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	

	@Override
	public void contextInitialized(ServletContextEvent sc) {
		// TODO Auto-generated method stub
		try{
			ConnectionPool cp = new ConnectionPool("com.mysql.jdbc.Driver", 
								"jdbc:mysql://localhost:3306/newsdb",
								"root", 
								"123456", 
								10);
			cp.init();
			sc.getServletContext().setAttribute("cp", cp);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
