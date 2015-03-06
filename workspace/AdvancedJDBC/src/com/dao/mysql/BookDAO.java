package com.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dao.IBookDAO;
import com.domain.Book;

public class BookDAO implements IBookDAO {
	private Connection con;
	public BookDAO() throws Exception{
		con = MySQLUtil.getConnection();
	}
	@Override
	public Book create(Book b) throws Exception {
		// TODO Auto-generated method stub
		String sql = "insert into books(name,author,price,publisher,create_time) "
				+ "values (?,?,?,?,now())";
		PreparedStatement pSta = con.prepareStatement(sql);
		
		pSta.setString(1, b.getName());
		pSta.setString(2, b.getAuthor());
		pSta.setDouble(3, b.getPrice());
		pSta.setString(4, b.getPublisher());
		
		pSta.executeUpdate();
		
		System.out.println("111");
		
		ResultSet rs = pSta.getGeneratedKeys();
		
		System.out.println("222");
		
		if(rs.next()){
			b.setId(rs.getInt(1));
		}
		rs.close();
		pSta.close();
		
		sql = "select create_time from books where id = ?";
		pSta = con.prepareStatement(sql);
		pSta.setInt(1, b.getId());
		
		rs = pSta.executeQuery();
		
		if(rs.next()){
			b.setCreate_time(rs.getTimestamp(1));
		}
		
		rs.close();
		pSta.close();
		
		return b;
	}

	@Override
	public List<Book> findAll() throws Exception {
		// TODO Auto-generated method atub
		Statement sta = con.createStatement();
		ResultSet rs = sta.executeQuery("select * from books");
		
		ArrayList<Book> books = new ArrayList<Book>();
		while(rs.next()){
			Book tb = new Book();
			tb.setId(rs.getInt("id"));
			tb.setName(rs.getString("name"));
			tb.setAuthor(rs.getString("author"));
			tb.setPrice(rs.getDouble("price"));
			tb.setPublisher(rs.getString("publisher"));
			tb.setCreate_time(rs.getTimestamp("create_time"));
			
			books.add(tb);
		}
		
		rs.close();
		sta.close();
		return books;
	} 
	
}
