package com.udemy.spring.hibernate;

import com.udemy.spring.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudent {

    private static void displayStudents(List<Student> students){
        for (Student tempStudent : students){
            System.out.println(tempStudent);
        }
    }

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // start a transaction
            session.beginTransaction();
            // query students
            List<Student> students = session.createQuery("from Student").getResultList();
            displayStudents(students);
            // query students: lastName='Doe'
            students = session.createQuery("from Student s where s.lastName='Doe'").getResultList();
            displayStudents(students);
            // query students: last name='Doe' OR firstName='Mary'
            students = session.createQuery("from Student s where s.lastName='Doe' OR s.firstName='Mary'").getResultList();
            displayStudents(students);
            // query students where email like udemy%
            students = session.createQuery("from Student s where s.email LIKE 'udemy%'").getResultList();
            displayStudents(students);
            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");
        } finally {
            factory.close();
        }

    }

}
