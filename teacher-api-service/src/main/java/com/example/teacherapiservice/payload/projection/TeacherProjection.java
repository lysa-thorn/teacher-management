package com.example.teacherapiservice.payload.projection;

import com.example.teacherapiservice.entity.Course;

import java.util.Collection;

public interface TeacherProjection {

    Long getId();
    String getFirst_name();
    String getLast_name();
    String getGender();
    String getEmail();
    String getPhone();
    String getStart_date();
    String getEnd_date();

    Salary getSalary();

    interface Salary{
        Long getId();
        String getSalary();

    }

    Collection<Course> getCourses();

    interface  Course{
        Long getId();
        String getName();
    }


}
