package com.udemy.spring.hibernate;

import com.udemy.spring.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudent {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            int studentId=1;
            // start a transaction
            session.beginTransaction();

            // retreive student based on the id: primary key
            Student student = session.get(Student.class, studentId);

            // delete student
            session.delete(student);

            // second approach
            session.createQuery("delete from Student where is=2").executeUpdate();

            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            factory.close();
        }

    }

}
