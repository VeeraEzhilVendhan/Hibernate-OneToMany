package com.spring.onetomany.bidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteCourses {
	
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
			
			Course c1=session.get(Course.class, 10);
			
			session.delete(c1);
			
	        session.getTransaction().commit();
			
	        System.out.println("Done");
		}
		finally
		{
			session.close();
			sessionFactory.close();
		}		
	}

}
