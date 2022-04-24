package com.udemy.spring.hibernate;

import com.udemy.spring.hibernate.entity.Course;
import com.udemy.spring.hibernate.entity.Instructor;
import com.udemy.spring.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructor {

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
            // create the objects
            Instructor tempInstructor = new Instructor("Jan", "Kowalski", "udemy@org.com");
            InstructorDetail tempInstructorDetail = new InstructorDetail("www.kowalski.com", "movies");
            // associate the objects
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            // start a transaction
            session.beginTransaction();

            // save the instructor
            // this will also save details object because of CascadeType.ALL
            session.save(tempInstructor);

            // commit transaction
            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }

    }

}
