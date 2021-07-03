package com.example.teacherapiservice.payload.projection;

import java.util.Collection;

public interface UserProjection {

    Long getId();
    String getUsername();
    String getEmail();
    String getGender();

    Collection<Role> getRoles();

    interface  Role{
        Long getId();
        String getName();
    }



}
