package com.example.CourseList.courseList.controller;

import com.example.CourseList.courseList.controller.service.CourseServiceImpl;
import com.example.CourseList.courseList.dto.CourseAllDto;
import com.example.CourseList.courseList.dto.StudentSlimDto;
import com.example.CourseList.courseList.entity.Course;
import com.example.CourseList.courseList.entity.Student;
import com.example.CourseList.courseList.map.MapStructImpl;
import com.example.CourseList.courseList.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/course")
public class MainController {
    private final MapStructImpl mapStruct;
    private final CourseServiceImpl courseService;
    private final StudentRepository studentRepository;
    @Autowired
    public MainController(MapStructImpl mapStruct, CourseServiceImpl courseService, StudentRepository studentRepository) {
        this.mapStruct = mapStruct;
        this.courseService = courseService;
        this.studentRepository = studentRepository;
    }
    @GetMapping("/createStudent/{id}")
    public String addCourse(Model model, @PathVariable Integer id){
        model.addAttribute("courseId", id);
        model.addAttribute("student", new Student());
        return "createStudent";
    }
    @GetMapping("/add")
    public String showCreateCourse(Model model){
        model.addAttribute("course", new Course());
        return "createCourse";
    }
    @PostMapping("/add")
    public String addCourse(Model model,@ModelAttribute Course course){
        course.setStudents(new ArrayList<>());
        courseService.save(course);
        return "redirect:/course";
    }
    @PostMapping("/students/{id}")
    public String addStudentToCourse(Model model,@ModelAttribute Student student, @PathVariable("id")Integer id){
        courseService.addStudent(student,id);
        return "redirect:/course/info/"+id;
    }
    @PutMapping("/")
    public String updateCourse(Model model, @RequestParam("course") Course course){
        courseService.update(course);
        return "index";
    }
    @GetMapping("/delete/{id}")
    public String deleteCourse(Model model, @PathVariable("id")Integer id){
        System.out.println(id);
        courseService.deleteCourse(id);
        return "redirect:/course";
    }
    @GetMapping("")
    public String getCourse(Model model){
        List<Course> courses=courseService.findAll();
        var courseAllDto= mapStruct.courseToCourseAllDtoS(courses);
        model.addAttribute("courseAllDtoS",courseAllDto);
        return "index";
    }
    @GetMapping("/info/{id}")
    public String getOneCourse(Model model, @PathVariable("id")Integer id){
        var course=courseService.findById(id);
        var courseDto=mapStruct.courseToCourseAllDto(course);

        List<StudentSlimDto> slim=new ArrayList<>();
        courseService.findStudentsByCourseId(id).forEach(student -> {
            slim.add(mapStruct.studentToStudentSlimDto(student));
        });
        model.addAttribute("courseDto",courseDto);
        model.addAttribute("studentSlim", slim);
        return "courseInfo";
    }
}
