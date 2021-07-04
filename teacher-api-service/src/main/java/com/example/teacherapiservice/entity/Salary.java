package com.example.teacherapiservice.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "teachers")
public class Salary {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(insertable=false, updatable=false, nullable = false)
    private Long id;
    private double salary;
    private Date startDate;
    private Date endDate;


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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "id=" + id +
                ", salary=" + salary +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
