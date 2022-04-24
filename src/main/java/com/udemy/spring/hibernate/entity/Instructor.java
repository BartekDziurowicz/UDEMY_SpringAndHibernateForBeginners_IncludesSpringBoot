package com.udemy.spring.hibernate.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="instructor")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Instructor {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    @NonNull
    private String firstName;

    @Column(name="last_name")
    @NonNull
    private String lastName;

    @Column(name="email")
    @NonNull
    private String email;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="instructor_detail_id")
    private InstructorDetail instructorDetail;

    @OneToMany(fetch=FetchType.LAZY, mappedBy ="instructor", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Course> courses;

    // add convenience method for bi-directional relationship
    public void add(Course tempCourse) {
        if (tempCourse == null) {
            courses = new ArrayList<>();
        }
        courses.add(tempCourse);
        tempCourse.setInstructor(this);
    }

}
