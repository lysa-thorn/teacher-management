package com.example.teacherapiservice.payload;

import java.sql.Date;

public class AddSalaryRequest {
    private Long id;
    private double salary;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
