package com.example.teacherapiservice.controller;

import com.example.teacherapiservice.controller.util.ApiResponse;
import com.example.teacherapiservice.controller.util.ApiStatus;
import com.example.teacherapiservice.entity.Course;
import com.example.teacherapiservice.payload.AddCourseRequest;
import com.example.teacherapiservice.payload.projection.UserProjection;
import com.example.teacherapiservice.service.CourseService;
import com.example.teacherapiservice.service.RoleService;
import com.example.teacherapiservice.service.UserService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user-mgt/course")

public class CourseController {

    public CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ApiResponse<List<Course>> findAll() {
        return new ApiResponse<>(
                ApiStatus.SUC_RETRIEVED.getCode(),
                ApiStatus.SUC_RETRIEVED.getMessage(),
                courseService.findAll()
        );
    }

    @PostMapping("/add")
    public ApiResponse AddCourse(@RequestBody AddCourseRequest addCourseRequest ){
        Course course = new Course();
        course.setName(addCourseRequest.getName());
        Course courseAdded = courseService.addCourse(course);

        return  new ApiResponse(
                ApiStatus.SUC_CREATED.getCode(),
                ApiStatus.SUC_CREATED.getMessage(),
                courseAdded
        );
    }

    @PostMapping("/edit")
    public ApiResponse EditCourse(@RequestBody AddCourseRequest addCourseRequest){
        Course course = courseService.findById(addCourseRequest.getId());
        course.setName(addCourseRequest.getName());
        Course courseAdded = courseService.addCourse(course);

        return  new ApiResponse(
                ApiStatus.SUC_CREATED.getCode(),
                ApiStatus.SUC_CREATED.getMessage(),
                courseAdded
        );
    }

    @DeleteMapping("/delete/{id}")
    public ApiResponse deleteCourse(@PathVariable Long id){
        return  new ApiResponse(
                ApiStatus.SUC_CREATED.getCode(),
                ApiStatus.SUC_CREATED.getMessage(),
                courseService.deleteCourse(id)
        );
    }


}
