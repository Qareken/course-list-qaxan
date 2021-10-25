package com.example.CourseList.courseList.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="definition")
    private String definition;
    @Column(name = "type")
    private String type;
    @Column(name = "mentor_course_name")
    private String mentorCourseName;
    @Transient
    private List<Student> students;
}
