package com.udemy.spring.hibernate;

import com.udemy.spring.hibernate.entity.Instructor;
import com.udemy.spring.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Delete {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {
            // begin
            session.beginTransaction();

            // get instructor by primary key / id
            int id = 1;
            Instructor tempInstructor = session.get(Instructor.class, id);

            // delete the instructors an also instrctiondetails because of cascade
            if (tempInstructor != null) {
                session.delete(tempInstructor);
            }

            // commit transaction
            session.getTransaction().commit();

        } finally {
            factory.close();
        }

    }

}
