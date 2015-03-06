package com.app;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.domain.Course;
import com.domain.Employee;
import com.domain.HourlyEmployee;
import com.domain.SalariedEmployee;
import com.domain.Student;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Configuration cfg = new Configuration().configure();
			
			SessionFactory sf = cfg.buildSessionFactory();
			
			Session session = sf.openSession();
			
			Transaction tx = session.beginTransaction();
			/*
			Course c1 = new Course();
			c1.setName("Java");
			
			Course c2 = new Course();
			c2.setName("C++");
			
			Student s1 = new Student();
			s1.setName("steven");
			s1.getCourses().add(c1);
			s1.getCourses().add(c2);
			
			Student s2 = new Student();
			s2.setName("jack");
			s2.getCourses().add(c2);
			
			session.save(c1);
			session.save(c2);
			session.save(s1);
			session.save(s2);
			*/
			
			/*Student s =(Student) session.get(Student.class, 2);
			System.out.println(s.getName());
			for(Course tc: s.getCourses()){
				System.out.println(tc.getName());
			}
			
			Course cs = (Course)session.get(Course.class, 2);
			System.out.println(cs.getName());
			for(Student s1: cs.getStudents()){
				System.out.println(s1.getName());
			}*/
			
			/*HourlyEmployee he = new HourlyEmployee();
			he.setName("steven");
			he.setRate(15.0);
			
			session.save(he);
			
			SalariedEmployee se = new SalariedEmployee();
			se.setName("hhhh");
			se.setSalary(20000.);
			
			session.save(se);
			*/
			
			Employee te = (Employee)session.get(Employee.class, 2);
			System.out.println(te.getClass());
			
			if(te instanceof SalariedEmployee){
				SalariedEmployee se = (SalariedEmployee)te;
				System.out.println(se.getSalary());
			}
			
			Query q = session.createQuery("from Employee e where e.name = :en");
			q.setString("en", "hhhh");
			
			Employee res = (Employee)q.uniqueResult();
			if(res != null){
				if(res instanceof HourlyEmployee){
					System.out.println("jianzhi");
				}
				else{
					System.out.println("quanzhi");
				}
			}
			else{
				System.out.println("null");
			}
			
			tx.commit();
			session.close();
			sf.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
