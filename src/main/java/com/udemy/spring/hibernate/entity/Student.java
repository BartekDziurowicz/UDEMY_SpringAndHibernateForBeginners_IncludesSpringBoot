package com.udemy.spring.hibernate.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name="student")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Student {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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

    @ManyToMany(fetch=FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name="course_student",
            joinColumns=@JoinColumn(name="student_id"),
            inverseJoinColumns=@JoinColumn(name="course_id")
    )
    private List<Course> courses;

}
