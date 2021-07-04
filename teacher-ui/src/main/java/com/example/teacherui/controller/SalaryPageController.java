package com.example.teacherui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/salary")
public class SalaryPageController {
    @RequestMapping("/")
    public String listTeacher(){
        return "salary/salary-list";
    }

    @RequestMapping("/add")
    public String addTeacher(){
        return "salary/salary-add";
    }


    @RequestMapping("/edit/{id}")
    public String editTeacher(ModelMap modelMap, @PathVariable Long id){
        modelMap.addAttribute("value" , id);
        return "salary/salary-edit";
    }
    @RequestMapping("/delete/{id}")
    public String deleteTeacher(ModelMap modelMap, @PathVariable String id){
        modelMap.addAttribute("value" , id);
        return "redirect:/salary/";
    }
}
