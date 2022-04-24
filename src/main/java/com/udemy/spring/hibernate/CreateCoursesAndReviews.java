package com.udemy.spring.hibernate;

import com.udemy.spring.hibernate.entity.Course;
import com.udemy.spring.hibernate.entity.Instructor;
import com.udemy.spring.hibernate.entity.InstructorDetail;
import com.udemy.spring.hibernate.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesAndReviews {

    public static void main(String[] args) {

        // create session factory
        SessionFactory factory = new Configuration()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {

            // start a transaction
            session.beginTransaction();

            // create a course
            Course tempCourse = new Course("Arkham Horror");

            // add some reviews
            tempCourse.addReview(new Review("Great course"));
            tempCourse.addReview(new Review("Color from the Outer Space"));
            tempCourse.addReview(new Review("Another dummy example"));

            // save the course ... and leverage the cascade all
            System.out.println("Saving the course: " + tempCourse + " | " + tempCourse.getReviews());
            session.save(tempCourse);

            // commit transaction
            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }

    }

}
