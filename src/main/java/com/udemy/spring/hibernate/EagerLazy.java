package com.udemy.spring.hibernate;

import com.udemy.spring.hibernate.entity.Course;
import com.udemy.spring.hibernate.entity.Instructor;
import com.udemy.spring.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EagerLazy {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            // start a transaction
            session.beginTransaction();

            // get instructor from db
            int id = 1;
            Instructor tempInstructor = session.get(Instructor.class, id);
            System.out.println("Lazy session still opened: " + tempInstructor.getCourses());

            // commit transaction
            session.getTransaction().commit();

            // close the session
            session.close();

            System.out.println("Lazy session closed: " + tempInstructor.getCourses());

        } finally {
            session.close();
            factory.close();
        }

    }

}
