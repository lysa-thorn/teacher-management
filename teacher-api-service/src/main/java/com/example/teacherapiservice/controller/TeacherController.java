package com.example.teacherapiservice.controller;

import com.example.teacherapiservice.controller.util.ApiResponse;
import com.example.teacherapiservice.controller.util.ApiStatus;
import com.example.teacherapiservice.controller.util.Pagination;
import com.example.teacherapiservice.entity.Course;
import com.example.teacherapiservice.entity.Role;
import com.example.teacherapiservice.entity.Salary;
import com.example.teacherapiservice.entity.Teacher;
import com.example.teacherapiservice.payload.AddSalaryRequest;
import com.example.teacherapiservice.payload.AddTeacherRequest;
import com.example.teacherapiservice.payload.projection.TeacherProjection;
import com.example.teacherapiservice.service.CourseService;
import com.example.teacherapiservice.service.RoleService;
import com.example.teacherapiservice.service.SalaryService;
import com.example.teacherapiservice.service.TeacherService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user-mgt/teacher")
public class TeacherController {

    public TeacherService teacherService;
    public SalaryService salaryService;
    public CourseService courseService;

    //@RequestMapping(method = RequestMethod.GET)
    @Autowired
    public TeacherController(TeacherService teacherService, SalaryService salaryService, CourseService courseService){
        this.teacherService = teacherService;
        this.salaryService = salaryService;
        this.courseService = courseService;
    }


    //@RequestMapping(method = RequestMethod.GET)
    @Parameters({
            @Parameter(
                    in = ParameterIn.QUERY,
                    description = "Page you want to retrieve (0...N)",
                    name = "page",
                    content = @Content(schema = @Schema(type = "integer" , defaultValue = "0"))
            ),
            @Parameter(
                    in = ParameterIn.QUERY,
                    description = "Number of records per page.",
                    name = "size",
                    content = @Content(schema = @Schema(type = "integer" , defaultValue = "20"))
            )
    })
    @GetMapping
    //@Hidden
    public ApiResponse<List<TeacherProjection>> findAll(@Parameter(hidden = true) Pagination pagination){
        List<TeacherProjection> teacherProjection = teacherService.findTeacherProjection(pagination);
        return new ApiResponse<>(
                ApiStatus.SUC_RETRIEVED.getCode(),
                ApiStatus.SUC_RETRIEVED.getMessage(),
                teacherProjection,
                pagination
        );
    }

    @GetMapping("/find/{id}")
    public ApiResponse<TeacherProjection> findById(@PathVariable("id") Long id){
        TeacherProjection teacherProjection = teacherService.findTeacherProjectById(id);
        if(teacherProjection == null){
            return new ApiResponse<>(ApiStatus.NOT_FOUND.getCode(), ApiStatus.NOT_FOUND.getMessage());
        }
        return new ApiResponse<>(
                ApiStatus.SUC_RETRIEVED.getCode(),
                ApiStatus.SUC_RETRIEVED.getMessage(),
                teacherProjection
        );
    }

    @PostMapping  ("/add")//  =  @RequestMapping(method = RequestMethod.POST)
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

        return  new ApiResponse(
                ApiStatus.SUC_CREATED.getCode(),
                ApiStatus.SUC_CREATED.getMessage(),
                teacherAdded
        );
    }

}
