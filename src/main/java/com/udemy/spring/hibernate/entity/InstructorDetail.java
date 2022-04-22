package com.udemy.spring.hibernate.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "instructor_detail")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class InstructorDetail {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="youtube_channel")
    @NonNull
    private String youtubeChannel;

    @Column(name="hobby")
    @NonNull
    private String hobby;

}
