package com.example.teacherapiservice.service.impl;

import com.example.teacherapiservice.entity.Role;
import com.example.teacherapiservice.entity.Teacher;
import com.example.teacherapiservice.repository.RoleRepository;
import com.example.teacherapiservice.repository.TeacherRepository;
import com.example.teacherapiservice.service.RoleService;
import com.example.teacherapiservice.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
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
}
