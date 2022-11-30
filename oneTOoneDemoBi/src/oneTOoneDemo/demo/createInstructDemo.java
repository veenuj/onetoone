package oneTOoneDemo.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class createInstructDemo {

public static void main(String[] args) {
		
		
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(instructorDemo.class)
									.addAnnotatedClass(instructorDetails.class)
									.buildSessionFactory();
		
	
		// create session
		Session session = factory.getCurrentSession();
		
		try {
		
	
			
	
			session.beginTransaction();
			
			int theId=30;
			
			instructorDetails instructorDetail = session.get(instructorDetails.class, theId);
			
			System.out.println("instructor detail obj "+instructorDetail);
			
			System.out.println("associated instrcutor "+ instructorDetail.getInstructor());
			
			
			
			session.getTransaction().commit();
			
			System.out.println("!!!!!!!!!!!!!!DATA UPDATED!!!!!!!!!!!!!!!");
			
			
		} 
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			
			session.close();
			factory.close();
		}
				

	}
	
	
	
}
