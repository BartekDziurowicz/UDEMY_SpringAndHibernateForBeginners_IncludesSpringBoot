package com.udemy.spring.hibernate;

import com.udemy.spring.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudent {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // create a student object
            Student tempStudent = new Student("Indiana", "Jones", "indiana@org.com");
            // start a transaction
            session.beginTransaction();
            // save the student object
            System.out.println(tempStudent);
            session.save(tempStudent);
            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");

            // find out student's id: primary key
            System.out.println("Saved student. Generated id: " + tempStudent.getId());
            // now get new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();
            // retreive student basen on the id : priamry key
            System.out.println("Getting student with id: " + tempStudent.getId());
            Student student = session.get(Student.class, tempStudent.getId());
            System.out.println(student);
            // commit the transaction
            session.getTransaction().commit();
            System.out.println("Received with success!");
        } finally {
            factory.close();
        }

    }

}
