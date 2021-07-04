package com.example.teacherapiservice.controller;

import com.example.teacherapiservice.controller.util.ApiResponse;
import com.example.teacherapiservice.controller.util.ApiStatus;
import com.example.teacherapiservice.entity.Course;
import com.example.teacherapiservice.entity.Role;
import com.example.teacherapiservice.entity.Salary;
import com.example.teacherapiservice.entity.Teacher;
import com.example.teacherapiservice.payload.AddSalaryRequest;
import com.example.teacherapiservice.payload.AddTeacherRequest;
import com.example.teacherapiservice.service.CourseService;
import com.example.teacherapiservice.service.RoleService;
import com.example.teacherapiservice.service.SalaryService;
import com.example.teacherapiservice.service.TeacherService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user-mgt/teacher")
public class TeacherController {

    public TeacherService teacherService;
    public SalaryService salaryService;
    public CourseService courseService;

    @Autowired
    public TeacherController(TeacherService teacherService, SalaryService salaryService, CourseService courseService){
        this.teacherService = teacherService;
        this.salaryService = salaryService;
        this.courseService = courseService;
    }

    @PostMapping  //  =  @RequestMapping(method = RequestMethod.POST)
    public ApiResponse registerUser(@RequestBody AddTeacherRequest addTeacherRequest){

        Teacher teacher = new Teacher();
        teacher.setFirst_name(addTeacherRequest.getFirst_name());
        teacher.setLast_name(addTeacherRequest.getLast_name());
        teacher.setEmail(addTeacherRequest.getEmail());
        teacher.setGender(addTeacherRequest.getGender());
        teacher.setPhone(addTeacherRequest.getPhone());
        teacher.setStart_date(addTeacherRequest.getStart_date());
        teacher.setEnd_date(addTeacherRequest.getEnd_date());
        teacher.setSalary(addTeacherRequest.getSalary());

        // TODO: Add Role if exist
        List<Course> courses = new ArrayList<>();
        for(Long courseId : addTeacherRequest.getCourseId()){
            Course course = courseService.findById(courseId);
            courses.add(course);
        }
        teacher.setCourses(courses);
        Teacher teacherAdded = teacherService.addTeacher(teacher);
        System.out.println(teacher.toString());
        return  new ApiResponse(
                ApiStatus.SUC_CREATED.getCode(),
                ApiStatus.SUC_CREATED.getMessage(),
                teacherAdded
        );
    }

}
