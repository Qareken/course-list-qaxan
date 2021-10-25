package com.example.CourseList.courseList.dto;

import com.example.CourseList.courseList.entity.Course;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDto {
    @JsonProperty
    private Integer id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("course")
    private Course course;

}
