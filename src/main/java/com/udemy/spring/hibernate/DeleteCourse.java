package com.udemy.spring.hibernate;

import com.udemy.spring.hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourse {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            // start a transaction
            session.beginTransaction();

            // get the student Jane from database
            int courseId = 10;
            Course tempCourse = session.get(Course.class, courseId);

            // delete the course
            session.delete(tempCourse);

            // commit transaction
            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }

    }

}
