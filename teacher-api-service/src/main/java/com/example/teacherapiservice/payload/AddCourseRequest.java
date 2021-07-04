package com.example.teacherapiservice.payload;

public class AddCourseRequest {
    private  Long id;
    private String name;

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AddCourseRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
