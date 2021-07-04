package com.example.teacherui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/teacher")
public class TeacherPageController {
    @GetMapping("/")
    public String listTeacher(){
        return "teacher/teacher-list";
    }
    @GetMapping("/add")
    public String addTeacher(){
        return "teacher/teacher-add";
    }
}
