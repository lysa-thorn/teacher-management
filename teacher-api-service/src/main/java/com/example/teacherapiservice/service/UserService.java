package com.example.teacherapiservice.service;

import com.example.teacherapiservice.controller.util.Pagination;
import com.example.teacherapiservice.entity.User;
import com.example.teacherapiservice.payload.projection.UserCountProjection;
import com.example.teacherapiservice.payload.projection.UserProjection;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findByUsernameIgnoreCase(String username);
    User findByUsername(String username);
    List<User> findByEmailContainingIgnoreCaseOrderByIdDesc(String email);
    User findUserById(Long id);
    UserCountProjection countUser();



    UserProjection findUserProjectById(Long id);
    UserProjection findUserProjectionByUsername(String username);
    List<UserProjection> findUserProjection(Pagination pagination);
    User addUser(User user);

}
