package com.example.CourseList.courseList.controller.service;

import com.example.CourseList.courseList.entity.Course;
import com.example.CourseList.courseList.entity.Student;
import com.example.CourseList.courseList.repository.CourseRepository;
import com.example.CourseList.courseList.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public CourseServiceImpl(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void save(Course course) {
        if(course!=null)
        courseRepository.save(course);

    }

    @Override
    public Course findById(Integer id) {
        Optional<Course> course=courseRepository.findById(id);
        return course.orElse(null);
    }

    @Override
    public List<Student> findStudentsByCourseId(Integer id) {
        return studentRepository.findStudentsByCourseId(id);
    }

    @Override
    public List<Course> findAll() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    public void update(Course course) {
        courseRepository.save(course);

    }

    @Override
    public void deleteCourse(Integer id) {
        var list=findStudentsByCourseId(id);
        if(list!=null){
            list.forEach(studentRepository::delete);
        }
        courseRepository.deleteById(id);
    }

    @Override
    public void addStudent(Student student, Integer id) {
        Course course=findById(id);
        List<Student>list=findStudentsByCourseId(id);


        student.setCourse(course);
        studentRepository.save(student);
        list.add(student);
        course.setStudents(list);
        courseRepository.save(course);
    }
}
