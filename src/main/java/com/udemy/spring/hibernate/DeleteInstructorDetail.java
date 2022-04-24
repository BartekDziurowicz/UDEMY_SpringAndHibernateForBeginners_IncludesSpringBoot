package com.udemy.spring.hibernate;

import com.udemy.spring.hibernate.entity.Instructor;
import com.udemy.spring.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetail {

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

            // get the instructor detail object by "id"
            int id = 4;
            InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, id);

            // print the instructor detail
            System.out.println("tempInstructorDetail: " + tempInstructorDetail);

            // print the assicaiated instructor
            System.out.println("associated instructor: " + tempInstructorDetail.getInstructor());

            // remove the associated object reference
            // break bi-directional link
            tempInstructorDetail.getInstructor().setInstructorDetail(null);

            // delete the instructor detail
            System.out.println("Delete tempInstructorDetail: " + tempInstructorDetail);
            session.delete(tempInstructorDetail);

            // commit transaction
            session.getTransaction().commit();

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            // handle conenction leak issue
            session.close();

            factory.close();
        }

    }

}
