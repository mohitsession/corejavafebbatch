package com.learn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
        configuration.configure("database.cfg.xml");
        
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Student newStudent = new Student("Bob", "bob@example.com","java",66);
            session.persist(newStudent); 
            transaction.commit();
            System.out.println("Success! Maven Student saved.");

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); 
            }
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }

	}

}
