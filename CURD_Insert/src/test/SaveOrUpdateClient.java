package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import beans.Student;

public class SaveOrUpdateClient {
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("resources/Hibernate.cfg.xml");
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		
		Student st  = new Student();
		st.setId(111);
		st.setEmail("sahil@gmail.com");
		st.setName("sahil");
		
		session.saveOrUpdate(st);//it will update the record of 111
		t.commit();//query will execute here
		
		session.close();
		sf.close();

		System.out.println("Table updated successfully");
	}

}
