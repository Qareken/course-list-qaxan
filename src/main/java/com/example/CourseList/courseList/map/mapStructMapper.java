package com.example.CourseList.courseList.map;

import com.example.CourseList.courseList.dto.CourseAllDto;
import com.example.CourseList.courseList.dto.CourseDto;
import com.example.CourseList.courseList.dto.StudentDto;
import com.example.CourseList.courseList.dto.StudentSlimDto;
import com.example.CourseList.courseList.entity.Course;
import com.example.CourseList.courseList.entity.Student;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
        componentModel="spring"
)

public interface mapStructMapper {
        StudentSlimDto studentToStudentSlimDto(Student student);
        CourseAllDto courseToCourseAllDto(Course course);
        StudentDto studentToStudentDto(Student student);
        CourseDto courseToCourseDto(Course course);
        List<CourseAllDto>courseToCourseAllDtoS(List<Course> courses);
}
