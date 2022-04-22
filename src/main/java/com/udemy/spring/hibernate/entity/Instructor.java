package com.udemy.spring.hibernate.entity;

import jakarta.persistence.*;
import lombok.*;

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

}
