package com.example.CourseList.courseList.repository;

import com.example.CourseList.courseList.entity.Course;
import com.example.CourseList.courseList.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {


}
