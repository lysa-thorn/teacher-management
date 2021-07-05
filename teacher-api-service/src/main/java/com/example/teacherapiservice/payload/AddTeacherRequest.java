package com.example.teacherapiservice.payload;

import com.example.teacherapiservice.entity.Course;
import com.example.teacherapiservice.entity.Salary;
import com.example.teacherapiservice.payload.projection.UserProjection;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

public abstract class AddTeacherRequest {
    private Long id;
    private String first_name;
    private String last_name;
    private String email;
    private String gender;
    private String phone;
    private Salary salary;
    private List<Long> courseId;
    private Date start_date;
    private Date end_date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public List<Long> getCourseId() {
        return courseId;
    }

    public void setCourseId(List<Long> courseId) {
        this.courseId = courseId;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }
}
