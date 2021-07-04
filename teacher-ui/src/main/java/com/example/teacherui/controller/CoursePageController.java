package com.example.teacherui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/course")
public class CoursePageController {
    @RequestMapping({ "","/", "/list"})
    public String CourseList(){
        return "course/course-list";
    }

    @RequestMapping( "/add")
    public String addCourse(){
        return "course/course-add";
    }

    @RequestMapping( "/edit/{id}")
    public String editCourse(@PathVariable Long id){
        return "course/course-edit";
    }

    @RequestMapping( "/delete/{id}")
    public String deleteCourse(@PathVariable Long id){
        return null;
    }



}
