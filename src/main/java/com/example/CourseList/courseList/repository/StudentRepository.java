package com.example.CourseList.courseList.repository;

import com.example.CourseList.courseList.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
    @Query("select f from Student as f where f.course.id=?1")
    List<Student> findStudentsByCourseId(Integer id);
}
