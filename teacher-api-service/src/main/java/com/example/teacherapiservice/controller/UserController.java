package com.example.teacherapiservice.controller;

import com.example.teacherapiservice.controller.util.ApiResponse;
import com.example.teacherapiservice.controller.util.ApiStatus;
import com.example.teacherapiservice.controller.util.Pagination;
import com.example.teacherapiservice.entity.Role;
import com.example.teacherapiservice.entity.User;
import com.example.teacherapiservice.payload.AddUserRequest;
import com.example.teacherapiservice.payload.projection.UserProjection;
import com.example.teacherapiservice.service.RoleService;
import com.example.teacherapiservice.service.UserService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController  //  @Controller + @ResponseBody
//@Hidden
@RequestMapping("/api/v1/user-mgt/user")
public class UserController {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public UserController(UserService userService,
                          RoleService roleService){
        this.userService = userService;
        this.roleService = roleService;
    }

    //@RequestMapping(method = RequestMethod.GET)
    @Parameters({
            @Parameter(
                    in = ParameterIn.QUERY,
                    description = "Page you want to retrieve (0...N)",
                    name = "page",
                    content = @Content(schema = @Schema(type = "integer" , defaultValue = "0"))
            ),
            @Parameter(
                    in = ParameterIn.QUERY,
                    description = "Number of records per page.",
                    name = "size",
                    content = @Content(schema = @Schema(type = "integer" , defaultValue = "20"))
            )
    })


    @GetMapping("/{user-id}")
    public ApiResponse<UserProjection> findById(@PathVariable("user-id") Long id){
        UserProjection userProjection = userService.findUserProjectById(id);
        if(userProjection == null){
            return new ApiResponse<>(ApiStatus.NOT_FOUND.getCode(), ApiStatus.NOT_FOUND.getMessage());
        }
        return new ApiResponse<>(
                ApiStatus.SUC_RETRIEVED.getCode(),
                ApiStatus.SUC_RETRIEVED.getMessage(),
                userProjection
        );
    }


    @PutMapping // =  @RequestMapping(method = RequestMethod.PUT)
    public ApiResponse updateUser(/* UpdateUserRequest updateUserRequest */){

        // implement code update


        return  new ApiResponse(
                ApiStatus.SUC_CREATED.getCode(),
                ApiStatus.SUC_CREATED.getMessage()
        );
    }

}
