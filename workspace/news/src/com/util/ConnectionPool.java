package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;

public class ConnectionPool {
	private LinkedList<Connection> freeConnections 
		= new LinkedList<Connection>();
	private Hashtable<Thread,Connection> bondConnections 
		= new Hashtable<Thread,Connection>();
	
	private String driver;
	private String url;
	private String user;
	private String pass;
	
	private int size;
	
	public ConnectionPool(String driver,String url,String user,String pass,int size){
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.pass = pass;
		this.size = size;
	}
	
	public void init() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		for(int i=0; i<size; i++){
			Connection con = DriverManager.getConnection(url,user,pass);
			freeConnections.add(con);
		}
	}
	
	public void destroy() throws Exception{
		Iterator<Connection> it = freeConnections.iterator();
		while(it.hasNext()){
			Connection con = it.next();
			con.close();
		}
		freeConnections.clear();
		
		Enumeration<Connection> ee = bondConnections.elements();
		while(ee.hasMoreElements()){
			Connection con = ee.nextElement();
			con.close();
		}
		bondConnections.clear();
	}
	
	public synchronized Connection getConnection(){
		Connection con = bondConnections.get(Thread.currentThread());
		if(con != null){
			return con;
		}
		
		while(freeConnections.isEmpty()){
			try{
				wait();
			}
			catch(Exception e){
				
			}
		}

		con = freeConnections.removeFirst();
		bondConnections.put(Thread.currentThread(), con);
		return con;
	}
	
	public synchronized void releaseConnection(){
		Connection con = bondConnections.remove(Thread.currentThread());
		if(con != null){
			freeConnections.add(con);
			try{
				notify();
			}
			catch(Exception e){
				
			}
		}
	}
	
}