package com.udemy.spring.hibernate;

import com.udemy.spring.hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCoursesAndStudents {

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

            // create a course
            Course tempCourse = new Course("Arkham Horror");

            // save the course
            session.save(tempCourse);

            // create students
            Student tempStudent1 = new Student("John", "Doe", "john@mail.com");
            Student tempStudent2 = new Student("Jane", "Doe", "jane@mail.com");

            // add students to the course
            tempCourse.addStudent(tempStudent1);
            tempCourse.addStudent(tempStudent2);

            // save students
            session.save(tempStudent1);
            session.save(tempStudent2);

            // commit transaction
            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }

    }

}
