package com.example.CourseList.courseList.map;

import com.example.CourseList.courseList.dto.CourseAllDto;
import com.example.CourseList.courseList.dto.CourseDto;
import com.example.CourseList.courseList.dto.StudentDto;
import com.example.CourseList.courseList.dto.StudentSlimDto;
import com.example.CourseList.courseList.entity.Course;
import com.example.CourseList.courseList.entity.Student;
import org.springframework.stereotype.Component;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.List;
@Generated(value = "org.mapstruct.ap.MappingProcessor")
@Component
public class MapStructImpl implements mapStructMapper{
    @Override
    public StudentSlimDto studentToStudentSlimDto(Student student) {
        if(student==null)return null;
        StudentSlimDto studentSlimDto=new StudentSlimDto();
        studentSlimDto.setId(student.getId());
        studentSlimDto.setName(student.getName());
        studentSlimDto.setEmail(student.getEmail());
        return studentSlimDto;
    }

    @Override
    public CourseAllDto courseToCourseAllDto(Course course) {
        if(course==null)
        return null;
        CourseAllDto courseAllDto=new CourseAllDto();
        courseAllDto.setId(course.getId());
        courseAllDto.setName(course.getName());
        List<StudentSlimDto> slim=new ArrayList<>();
        if(course.getStudents()!=null)
        course.getStudents().forEach(c->{
            System.out.println(c.getName());
            slim.add(studentToStudentSlimDto(c));
        });
        courseAllDto.setStudents(slim);
        return courseAllDto;
    }
    private List<StudentSlimDto> setSlim(List<Student>students){
        if(students==null)return null;
        List<StudentSlimDto> list=new ArrayList<>();
        students.forEach(student ->
                list.add(studentToStudentSlimDto(student))
                );
        return list;
    }

    @Override
    public StudentDto studentToStudentDto(Student student) {
        if(student==null)
        return null;
        StudentDto studentDto=new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setCourse(student.getCourse());
        return studentDto;
    }

    @Override
    public CourseDto courseToCourseDto(Course course) {
        if(course==null)
        return null;
        CourseDto courseDto=new CourseDto();
        courseDto.setId(course.getId());
        courseDto.setName(course.getName());
        courseDto.setDefinition(course.getDefinition());
        courseDto.setStudents(course.getStudents());
        return courseDto;
    }

    @Override
    public List<CourseAllDto> courseToCourseAllDtoS(List<Course> courses) {
        if(courses==null)
        return null;
        List<CourseAllDto> courseAllDtoList=new ArrayList<>();
        courses.forEach(course -> courseAllDtoList.add(courseToCourseAllDto(course)));
        return courseAllDtoList;
    }
}
