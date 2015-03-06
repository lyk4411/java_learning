package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.domain.News;

public class NewsDAO {
	private Connection connection;
	
	public NewsDAO(Connection con){
		this.connection = con;
	}
	
	public List<News> findAll() throws Exception{
		Statement sta = connection.createStatement();
		ResultSet rs = sta.executeQuery("select * from news");
		
		ArrayList<News> newses = new ArrayList<News>();
		
		while(rs.next()) {
			News n = new News();
			n.setId(rs.getInt("id"));
			n.setTitle(rs.getString("title"));
			n.setContent(rs.getString("content"));
			n.setCreateTime(rs.getTimestamp("create_time"));
			
			newses.add(n);
		}
		
		rs.close();
		sta.close();
		
		return newses;
	
	}
}
