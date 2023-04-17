package com.spring.onetomany.bidirectional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import net.bytebuddy.asm.Advice.ArgumentHandler.Factory;

public class Main {

	public static void main(String[] args) {
	 
		SessionFactory sessionfactory=new Configuration().configure()
				.addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetails.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session=sessionfactory.getCurrentSession();
		
		try
		{
//			Instructor inst=new Instructor("John","N","John.n@gmail.com");
//			InstructorDetails instdtl=new InstructorDetails("Learn with John", "reading");
//			Course course=new Course("Digital marketing");
//			inst.setInstructordetails(instdtl);
			
			session.beginTransaction();
			
			Instructor inst1=session.get(Instructor.class, 1);
			Course course1=new Course("Learn PhotoShop");
			Course course2=new Course("Learn Lightroom");
			
			inst1.addCourse(course1);
			inst1.addCourse(course2);
			
			session.save(course1);
			session.save(course2);
			
			session.getTransaction().commit();
		}
		finally
		{
			session.close();
			sessionfactory.close();
		}

	}

}
