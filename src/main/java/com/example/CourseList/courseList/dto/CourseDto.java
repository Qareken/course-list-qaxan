package com.example.CourseList.courseList.dto;

import com.example.CourseList.courseList.entity.Student;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CourseDto {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("definition")
    private String definition;
    @JsonProperty("students")
    private List<Student> students;
}
