package com.example.teacherapiservice.service;

import com.example.teacherapiservice.entity.Role;
import com.example.teacherapiservice.entity.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher addTeacher(Teacher teacher);
    List<Teacher> findAll();
    Teacher findById(Long id);

}
