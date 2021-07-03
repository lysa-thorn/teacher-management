package com.example.teacherapiservice.entity;


import javax.persistence.*;

@Entity
@Table(name = "tu_role")
public class Role {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(insertable=false, updatable=false, nullable = false)
    private Long id;

    @Column(unique = true)
    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
