package com.udemy.spring.hibernate.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="course")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="title")
    @NonNull
    private String title;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="instructor_id")
    @ToString.Exclude
    private Instructor instructor;

}
