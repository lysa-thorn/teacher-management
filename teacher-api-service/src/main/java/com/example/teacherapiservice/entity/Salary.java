package com.example.teacherapiservice.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "salaries")
public class Salary {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(insertable=false, updatable=false, nullable = false)
    private Long id;
    @Column(unique = true)
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

    @Override
    public String toString() {
        return "Salary{" +
                "id=" + id +
                ", salary=" + salary +
                '}';
    }
}
