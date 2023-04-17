package com.spring.onetomany.bidirectional;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class GetCourses {
	
	public static void main(String[] args) {
		
		SessionFactory sessionFactory=new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetails.class)
				.addAnnotatedClass(Course.class).buildSessionFactory();
		
		Session session=sessionFactory.getCurrentSession();		
		try
		{
			session.beginTransaction();
			
			Instructor inst=session.get(Instructor.class, 1);
			
			System.out.println(inst);
			
			System.out.println(inst.getCourses());
			
			System.out.println("Done");
		}
		finally
		{
			session.close();
			sessionFactory.close();
		}		
	}

}
