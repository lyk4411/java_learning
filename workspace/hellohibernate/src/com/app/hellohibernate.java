package com.app;

import java.sql.Timestamp;
import java.util.Calendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.domain.Book;

public class hellohibernate {
	public static Timestamp getCurTime(){
		Calendar c = Calendar.getInstance();
		return new Timestamp(c.getTime().getTime());
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Configuration cfg = new Configuration().configure();
			
			SessionFactory sf = cfg.buildSessionFactory();
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			
			//Book b = new Book();
			//b.setName("C++ primer");
			//b.setAuthor("steven");
			//b.setPrice(98.0);
			//b.setCreateTime(getCurTime());
			
			//session.save(b);
			
			Book b = (Book)session.get(Book.class, 1);
			if(b != null){
				//b.setPrice(108.0);
				System.out.println(b.getName());
			}
			
			tx.commit();
			session.close();
			sf.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}//
}
