package com.example.teacherapiservice.service;

import com.example.teacherapiservice.entity.Role;
import com.example.teacherapiservice.entity.Salary;

import java.util.List;

public interface SalaryService {

    Salary addSalary(Salary salary);
    List<Salary> findAll();
    Salary findById(Long id);
    Salary editSalary(Salary salary);
    boolean deleteSalary(Long id);

}
