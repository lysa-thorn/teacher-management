package com.example.teacherapiservice.controller;

import com.example.teacherapiservice.controller.util.ApiResponse;
import com.example.teacherapiservice.controller.util.ApiStatus;
import com.example.teacherapiservice.entity.Course;
import com.example.teacherapiservice.entity.Role;
import com.example.teacherapiservice.entity.Salary;
import com.example.teacherapiservice.payload.AddCourseRequest;
import com.example.teacherapiservice.payload.AddSalaryRequest;
import com.example.teacherapiservice.service.RoleService;
import com.example.teacherapiservice.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user-mgt/salary")
public class SalaryController {

    public SalaryService salaryService;

    @Autowired
    public SalaryController(SalaryService salaryService){
        this.salaryService = salaryService;
    }

    @GetMapping
    public ApiResponse<List<Salary>> findAll(){
        return new ApiResponse<>(
                ApiStatus.SUC_RETRIEVED.getCode(),
                ApiStatus.SUC_RETRIEVED.getMessage(),
                salaryService.findAll()
                );
    }

    @PostMapping("/add")
    public ApiResponse AddSalary(@RequestBody AddSalaryRequest addSalaryRequest ){
        Salary salary = new Salary();
        salary.setSalary(addSalaryRequest.getSalary());
        Salary salaryAdded = salaryService.addSalary(salary);

        return  new ApiResponse(
                ApiStatus.SUC_CREATED.getCode(),
                ApiStatus.SUC_CREATED.getMessage(),
                salaryAdded
        );
    }


    @GetMapping("/find/{id}")
    public ApiResponse findSalary(@PathVariable Long id){
        Salary salary = salaryService.findById(id);

        return  new ApiResponse(
                ApiStatus.SUC_CREATED.getCode(),
                ApiStatus.SUC_CREATED.getMessage(),
                salary
        );
    }

    @PostMapping("/edit")
    public ApiResponse editSalary(@RequestBody AddSalaryRequest addSalaryRequest ){
        Salary salary = salaryService.findById(addSalaryRequest.getId());
        salary.setSalary(addSalaryRequest.getSalary());
        Salary salaryEdited = salaryService.editSalary(salary);

        return  new ApiResponse(
                ApiStatus.SUC_CREATED.getCode(),
                ApiStatus.SUC_CREATED.getMessage(),
                salaryEdited
        );
    }

    @GetMapping("/delete/{id}")
    public ApiResponse deleteSalary(@PathVariable Long id){
        return  new ApiResponse(
                ApiStatus.SUC_CREATED.getCode(),
                ApiStatus.SUC_CREATED.getMessage(),
                salaryService.deleteSalary(id)
        );
    }

}
