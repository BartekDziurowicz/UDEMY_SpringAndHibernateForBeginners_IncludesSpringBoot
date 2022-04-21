package com.udemy.spring.hibernate;

import com.udemy.spring.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKey {

    public static void main(String[] args) {
        // create session factory
        SessionFactory factory = new Configuration()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // create a student object
            Student tempStudent1 = new Student("John", "Doe", "john@org.com");
            Student tempStudent2 = new Student("Mary", "Public", "mary@org.com");
            Student tempStudent3 = new Student("Bonita", "Applebum", "udemy@org.com");
            // start a transaction
            session.beginTransaction();
            // save the student object
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);
            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }

}
