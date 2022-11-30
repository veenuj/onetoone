package oneTOoneDemo.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class createDataInstruct {

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
		
			
			
			instructorDemo tempInstructor = 
					new instructorDemo("garg","soam","sgarg@gmail.com");
			
			instructorDetails tempInstructorDetail = 
						new instructorDetails("http://www.youtube.com/soam", "reading");
			
			
			// associate objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);
		
			
			
	
			session.beginTransaction();
			

					// save instructor
			// NOTE: this will ALSO save details object because CascadeType.ALL
			System.out.println("saving instructor::::"+tempInstructor);
			session.save(tempInstructor);

			
			session.getTransaction().commit();
			
			System.out.println("!!!!!!!!!!!!!!DATA UPDATED!!!!!!!!!!!!!!!");
			
			
		} finally {
			factory.close();
		}
				

	}
	
	
}
