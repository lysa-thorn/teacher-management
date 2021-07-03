package com.example.teacherapiservice.service.impl;

import com.example.teacherapiservice.controller.util.Pagination;
import com.example.teacherapiservice.entity.User;
import com.example.teacherapiservice.payload.projection.UserCountProjection;
import com.example.teacherapiservice.payload.projection.UserProjection;
import com.example.teacherapiservice.repository.UserRepository;
import com.example.teacherapiservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByUsernameIgnoreCase(String username) {
        return userRepository.findByUsernameIgnoreCase(username);
    }

    @Override
    public List<User> findByEmailContainingIgnoreCaseOrderByIdDesc(String email) {
        return userRepository.findByEmailContainingIgnoreCaseOrderByIdDesc(email);
    }

    @Override
    public List<UserProjection> findUserProjection(Pagination pagination) {
        Page<UserProjection> userProjections = userRepository.findUserProjectionBy(
                        PageRequest.of(pagination.getPage(), pagination.getSize())
                );
        pagination.setTotalCounts(userProjections.getTotalElements());
        return userProjections.getContent();
    }

    @Override
    public UserProjection findUserProjectionByUsername(String username) {
        return userRepository.findUserProjectionByUsername(username);
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public UserProjection findUserProjectById(Long id) {
        return userRepository.findUserProjectionById(id);
    }

    @Override
    public UserCountProjection countUser() {
        return userRepository.countUser();
    }


}
