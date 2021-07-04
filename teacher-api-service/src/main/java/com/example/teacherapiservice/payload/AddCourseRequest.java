package com.example.teacherapiservice.payload;

public class AddCourseRequest {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AddCourseRequest{" +
                "name='" + name + '\'' +
                '}';
    }
}
