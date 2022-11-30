package oneTOoneDemo.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class deleteInstructorDemo {

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
			
			int theId = 4;
			instructorDemo temInstructor =
					session.get(instructorDemo.class, theId);
			

			// delete it
			if(temInstructor != null) {
				System.out.println("delete instructor"+temInstructor);
				// NOTE: this will ALSO delete details object because CascadeType.ALL
				session.delete(temInstructor);
			}
			
			
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
