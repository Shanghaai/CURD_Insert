package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class SaveClient {
	
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
		
		
		int pk = (Integer)session.save(st);
		System.out.println(pk);
		
		t.commit();//query will execute here		
		session.close();
		sf.close();
		System.out.println("Record inserted successfully");
	}
}
