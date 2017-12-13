package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class PersistClient {
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("resources/Hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		
		Student st  = new Student();
		st.setEmail("sahilyahoo.siddiqui@gmail.com");
		st.setId(111);
		st.setName("Mohd Sahil");
		
		
		session.persist(st);
		t.commit();//query will execute here		
		
		session.close();
		sf.close();
		System.out.println(" data inserted ! persist() method does not return anything thats the basic diff b/w save and persist");		
		
	}

}
