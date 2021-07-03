package com.example.teacherapiservice.payload.projection;

import org.springframework.beans.factory.annotation.Value;

public interface UserCountProjection {

    //Long getCount();

    @Value("#{target.count}")
    Long getTotalUser();

}
