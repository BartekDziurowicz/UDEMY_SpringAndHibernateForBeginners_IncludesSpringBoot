package com.udemy.spring.hibernate;

import com.udemy.spring.hibernate.entity.Course;
import com.udemy.spring.hibernate.entity.Instructor;
import com.udemy.spring.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoin {

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

            // resolve lazy : Hibernate query with HQL
            // get instructor from db
            int id = 1;
            Query<Instructor> query = session.createQuery("SELECT i FROM Instructor i JOIN FETCH i.courses WHERE i.id=:theInstructorId", Instructor.class);
            // set parameter on query
            query.setParameter("theInstructorId", id);
            // execute query and get instructor
            Instructor tempInstructor = query.getSingleResult();

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
