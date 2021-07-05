package com.example.teacherapiservice.service.impl;

import com.example.teacherapiservice.entity.Course;
import com.example.teacherapiservice.entity.Salary;
import com.example.teacherapiservice.repository.CourseRepository;
import com.example.teacherapiservice.service.CourseService;
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
        return courseRepository.findAll();
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteCourse(Long id) {
        Course existedDepartment = courseRepository.findById(id).get();
        if(existedDepartment != null){
            courseRepository.deleteById(id);
            return true;
        }
        return false;

    }
    @Override
    public Course edit(Course course) {
        return courseRepository.save(course);
    }



}

