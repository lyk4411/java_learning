package com.app;

import java.sql.Timestamp;
import java.util.Calendar;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.domain.Group;
import com.domain.User;

public class testone2many {
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			try{
				Configuration cfg = new Configuration().configure();
				
				SessionFactory sf = cfg.buildSessionFactory();
				
				Session session = sf.openSession();
				
				Transaction tx = session.beginTransaction();
				
				/*Group g1 = new Group();
				g1.setName("administrator");
				
				Group g2 = new Group();
				g2.setName("guest");
				
				session.save(g1);
				session.save(g2);
				
				User u11 = new User();
				u11.setGroup(g1);
				u11.setUsername("steven");
				u11.setPassword("111");
				
				User u12 = new User();
				u12.setGroup(g1);
				u12.setUsername("hhhh");
				u12.setPassword("222");
				
				User u21 = new User();
				u21.setGroup(g2);
				u21.setUsername("aaaaa");
				u21.setPassword("333");
				
				User u22 = new User();
				u22.setGroup(g2);
				u22.setUsername("bbb");
				u22.setPassword("444");
				
				session.save(u22);
				session.save(u21);
				session.save(u11);
				session.save(u12);
				*/
				
				//User u = (User)session.get(User.class, 3);
				
				//System.out.println(u.getUsername());
				//System.out.println(u.getGroup().getName());
				
				Group g = (Group) session.get(Group.class, 2);
				for(User tu:g.getUsers()){
					System.out.println(tu.getUsername());
				}
				
				Group tg = new Group();
				tg.setName("new group2");
				
				User uu = new User();
				uu.setGroup(tg);
				uu.setUsername("aaaaaaaaa");
				uu.setPassword("dfafs");
				
				tg.getUsers().add(uu);
				
				session.save(tg);
				session.save(uu);
				
				tx.commit();
				session.close();
				sf.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}//17
}
