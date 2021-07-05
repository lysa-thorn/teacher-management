package com.example.teacherapiservice.service.impl;

import com.example.teacherapiservice.controller.util.Pagination;
import com.example.teacherapiservice.entity.Teacher;
import com.example.teacherapiservice.payload.projection.TeacherProjection;
import com.example.teacherapiservice.payload.projection.UserProjection;
import com.example.teacherapiservice.repository.TeacherRepository;
import com.example.teacherapiservice.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private TeacherRepository teacherRepository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository){
        this.teacherRepository = teacherRepository;
    }


    @Override
    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher findById(Long id) {
        return null;
    }

    @Override
    public TeacherProjection findTeacherProjectById(Long id) {
        return teacherRepository.findTeacherProjectionById(id);
    }

    @Override
    public List<TeacherProjection> findTeacherProjection(Pagination pagination) {
        Page<TeacherProjection> teacherProjection = teacherRepository.findTeacherProjectionBy(
                PageRequest.of(pagination.getPage(), pagination.getSize())
        );
        pagination.setTotalCounts(teacherProjection.getTotalElements());
        return teacherProjection.getContent();
    }
}
