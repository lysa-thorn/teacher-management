package com.example.teacherapiservice.service.impl;

import com.example.teacherapiservice.entity.Role;
import com.example.teacherapiservice.entity.Salary;
import com.example.teacherapiservice.repository.RoleRepository;
import com.example.teacherapiservice.repository.SalaryRepository;
import com.example.teacherapiservice.service.RoleService;
import com.example.teacherapiservice.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryServiceImpl implements SalaryService {

    private SalaryRepository salaryRepository;

    @Autowired
    public SalaryServiceImpl(SalaryRepository salaryRepository){
        this.salaryRepository = salaryRepository;
    }


    @Override
    public Salary addSalary(Salary salary) {
        return salaryRepository.save(salary);
    }

    @Override
    public List<Salary> findAll() {
        return salaryRepository.findAll();
    }

    @Override
    public Salary findById(Long id) {
        return salaryRepository.findById(id).orElse(null);
    }

    @Override
    public Salary editSalary(Salary salary) {
        return salaryRepository.save(salary);
    }

    @Override
    public boolean deleteSalary(Long id) {
        Salary existedDepartment = salaryRepository.findById(id).get();
        if(existedDepartment != null){
            salaryRepository.deleteById(id);
            return true;
        }
        return false;

    }
}
