package com.udemy.spring.hibernate;

import com.udemy.spring.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudent {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // create a student object
            Student tempStudent = new Student("Paul", "Wall", "udemy@org.com");
            // start a transaction
            session.beginTransaction();
            // save the student object
            session.save(tempStudent);
            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }

    }

}
