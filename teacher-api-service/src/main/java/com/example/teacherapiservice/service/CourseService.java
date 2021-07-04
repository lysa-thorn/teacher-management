package com.example.teacherapiservice.service;

import com.example.teacherapiservice.entity.Course;

import java.util.List;

public interface CourseService {
     Course addCourse(Course course);
     List<Course> findAll() ;
     Course findById(Long id);
     boolean deleteById(Long id);
     Course edit(Course course);
}


