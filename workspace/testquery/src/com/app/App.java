package com.app;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.domain.Book;
import com.domain.Group;
import com.domain.User;

@SuppressWarnings("deprecation")
public class App {
	public static void testCase001(Session session){
		Query query = session.createQuery("from Book");
		List<Book> books1 = query.list();
		for(Book tb : books1){
			System.out.println(tb.getName());
		}
		
		Criteria c = session.createCriteria(Book.class);
		List<Book> books2 = c.list();
		for(Book tb : books2){
			System.out.println(tb.getName());
		}
	}
	
	public static void testCase002(Session session){
		//Query q = session.createQuery("from Book b order by b.price desc");
		//List<Book> bs = q.list();
		//for(Book tb : bs){
		//	System.out.println(tb.getName() + ":" + tb.getPrice());
		//}
		
		Criteria c = session.createCriteria(Book.class);
		c.addOrder(Order.desc("name"));
		List<Book> books2 = c.list();
		for(Book tb : books2){
			System.out.println(tb.getName());
		}
	}
	public static void testCase003(Session session){
		//Query q = session.createQuery("from Book b order by b.price desc");
		//List<Book> bs = q.list();
		//for(Book tb : bs){
		//	System.out.println(tb.getName() + ":" + tb.getPrice());
		//}
		//Query q = session.createQuery("from Book b order by b.price desc");
		//q.setFirstResult(2);
		//q.setMaxResults(2);
		//List<Book> bs = q.list();
		//for(Book tb : bs){
		//		System.out.println(tb.getName() + ":" + tb.getPrice());
		//	}
		
		Criteria c = session.createCriteria(Book.class);
		c.addOrder(Order.asc("name"));
		c.setFirstResult(0);
		c.setMaxResults(2);
		List<Book> books2 = c.list();
		for(Book tb : books2){
			System.out.println(tb.getName());
		}
	}
	@SuppressWarnings("deprecation")
	public static void testCase004(Session session){
		//Query q = session.createQuery("from Book b order by b.price desc");
		//List<Book> bs = q.list();
		//for(Book tb : bs){
		//	System.out.println(tb.getName() + ":" + tb.getPrice());
		//}
		//Query q = session.createQuery("from Book b order by b.price desc");
		//q.setFirstResult(2);
		//q.setMaxResults(2);
		//List<Book> bs = q.list();
		//for(Book tb : bs){
		//		System.out.println(tb.getName() + ":" + tb.getPrice());
		//	}
		//Query q = session.createQuery("from Book b where b.author = :bookauthor");
		//q.setString("bookauthor", "steven");
		//List<Book> bs = q.list();
		//for(Book tb : bs){
		//	System.out.println(tb.getName() + ":" + tb.getPrice());
		//}
		
		Criteria c = session.createCriteria(Book.class);
		c.add(Expression.eq("author", "steven"));
		List<Book> bs = c.list();
		for(Book tb : bs){
			System.out.println(tb.getName() + ":" + tb.getPrice());
		}
	}
	
	public static void testCase005(Session session){
		//Query q = session.createQuery("from Book b order by b.price desc");
		//List<Book> bs = q.list();
		//for(Book tb : bs){
		//	System.out.println(tb.getName() + ":" + tb.getPrice());
		//}
		//Query q = session.createQuery("from Book b order by b.price desc");
		//q.setFirstResult(2);
		//q.setMaxResults(2);
		//List<Book> bs = q.list();
		//for(Book tb : bs){
		//		System.out.println(tb.getName() + ":" + tb.getPrice());
		//	}
		//Query q = session.createQuery("from Book b where b.author = :bookauthor");
		//q.setString("bookauthor", "steven");
		//List<Book> bs = q.list();
		//for(Book tb : bs){
		//	System.out.println(tb.getName() + ":" + tb.getPrice());
		//}
		//Query q = session.createQuery("from User u where u.group.name=:gn");
		//q.setString("gn", "guest");
		//List<User> us = q.list();
		//for(User tu : us){
		//	System.out.println(tu.getUsername() + ":" + tu.getGroup().getName());
		//}
		
		Criteria c = session.createCriteria(User.class);
		c.createAlias("group", "g").add(Restrictions.eq("g.name","administrator"));
		List<User> us = c.list();
		for(User tu : us){
			System.out.println(tu.getUsername() + ":" + tu.getGroup().getName());
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Configuration cfg = new Configuration().configure();
			
			SessionFactory sf = cfg.buildSessionFactory();
			
			Session session = sf.openSession();
			
			Transaction tx = session.beginTransaction();
			
			//Query query = session.createQuery("from Book");
			//List<Book> books1 = query.list();
			//for(Book tb : books1){
			//	System.out.println(tb.getName());
			//}
			
			//Criteria c = session.createCriteria(Book.class);
			//List<Book> books2 = c.list();
			//for(Book tb : books2){
			//	System.out.println(tb.getName());
			//}
			
			//testCase001(session);
			//testCase002(session);
			testCase005(session);
			
			tx.commit();
			session.close();
			sf.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
