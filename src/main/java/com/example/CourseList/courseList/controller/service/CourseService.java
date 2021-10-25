package com.example.CourseList.courseList.controller.service;

import com.example.CourseList.courseList.entity.Course;
import com.example.CourseList.courseList.entity.Student;

import java.util.List;

public interface CourseService {
    void save(Course course);
    Course findById(Integer id);
    List<Student>findStudentsByCourseId(Integer id);
    List<Course>findAll();
    void update(Course course);
    void deleteCourse(Integer id);
    void addStudent(Student student, Integer id);
}
