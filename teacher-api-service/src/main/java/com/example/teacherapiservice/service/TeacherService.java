package com.example.teacherapiservice.service;

import com.example.teacherapiservice.controller.util.Pagination;
import com.example.teacherapiservice.entity.Teacher;
import com.example.teacherapiservice.payload.projection.TeacherProjection;
import com.example.teacherapiservice.payload.projection.UserProjection;

import java.util.List;

public interface TeacherService {

    Teacher addTeacher(Teacher teacher);
    List<Teacher> findAll();
    Teacher findById(Long id);
    TeacherProjection findTeacherProjectById(Long id);
    List<TeacherProjection> findTeacherProjection(Pagination pagination);
}
