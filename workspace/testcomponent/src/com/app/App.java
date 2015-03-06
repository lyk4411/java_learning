package com.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.domain.Address;
import com.domain.Customer;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Configuration cfg = new Configuration().configure();
			
			SessionFactory sf = cfg.buildSessionFactory();
			
			Session session = sf.openSession();
			
			Transaction tx = session.beginTransaction();
			/*
			Address homeAddress = new Address();
			homeAddress.setCity("shanghai");
			homeAddress.setStreet("huanhai road");
			
			Address companyAddress = new Address();
			companyAddress.setCity("beijing");
			companyAddress.setStreet("yanan road");
			
			Customer c = new Customer();
			c.setName("steven");
			c.setHome(homeAddress);
			c.setCompany(companyAddress);
			
			session.save(c);
			*/
			
			Customer c = (Customer)session.get(Customer.class, 2);
			System.out.println(c.getHome().getStreet());
			c.getHome().setStreet("hongqiao road");
			System.out.println(c.getHome().getStreet());

			tx.commit();
			session.close();
			sf.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
