package com.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import com.dao.IBookDAO;
import com.dao.mysql.BookDAO;
import com.domain.Book;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			//Class.forName("com.mysql.jdbc.Driver");
			//String url = "jdbc:mysql://localhost:3306/bookstore";
			//String user = "root";
			//String password = "123456";
			
			//Connection con = DriverManager.getConnection(url,user,password);
			//con.setAutoCommit(false);
			//Statement sta = con.createStatement();
			Book tb = new Book();
			tb.setName("DAO Design pattern");
			tb.setAuthor("steven");
			tb.setPrice(28);
			tb.setPublisher("OJJ");
			
			IBookDAO bookDAO = new BookDAO();
			
			System.out.println("1");
			bookDAO.create(tb);
			System.out.println("2");
			List<Book> books = bookDAO.findAll();
			Iterator<Book> it = books.iterator();
			
			while(it.hasNext()){
				Book b = it.next();
				System.out.println(b.getName() + "," + b.getCreate_time() );
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
