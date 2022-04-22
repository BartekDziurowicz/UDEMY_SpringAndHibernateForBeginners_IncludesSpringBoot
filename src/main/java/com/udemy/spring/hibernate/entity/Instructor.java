package com.udemy.spring.hibernate.entity;

import com.sun.istack.NotNull;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="Instructor")
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
    @NotNull
    private String firstName;

    @Column(name="last_name")
    @NotNull
    private String lastName;

    @Column(name="email")
    @NotNull
    private String email;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="instructor_detail_id")
    private InstructorDetail instructorDetail;

}
