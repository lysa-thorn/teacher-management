package com.example.teacherapiservice.service;

import com.example.teacherapiservice.entity.Role;

import java.util.List;

public interface RoleService {

    Role addRole(String roleName);
    List<Role> findAll();
    Role findById(Long id);

}
