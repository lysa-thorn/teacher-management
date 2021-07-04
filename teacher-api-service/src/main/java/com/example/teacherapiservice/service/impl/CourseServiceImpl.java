package com.example.teacherapiservice.service.impl;

import com.example.teacherapiservice.entity.Course;
import com.example.teacherapiservice.entity.Role;
import com.example.teacherapiservice.repository.CourseRepository;
import com.example.teacherapiservice.repository.RoleRepository;
import com.example.teacherapiservice.service.CourseService;
import com.example.teacherapiservice.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> findAll() {
        return null;
    }

    @Override
    public Course findById(Long id) {
        return null;
    }
}
