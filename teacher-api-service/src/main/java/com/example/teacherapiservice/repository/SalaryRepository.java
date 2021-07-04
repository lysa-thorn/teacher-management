package com.example.teacherapiservice.repository;

import com.example.teacherapiservice.entity.Role;
import com.example.teacherapiservice.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Long> {


}
