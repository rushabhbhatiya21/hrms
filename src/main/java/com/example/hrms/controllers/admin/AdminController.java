package com.example.hrms.controllers.admin;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping("")
    public String admin(){
        return "admin/basehtml";
    }

    @PostMapping("/submitEmployeeData")
    @ResponseBody
    public ResponseEntity<String> submitEmpData() {
        return null;
    }

    @GetMapping("/addEmployee")
    public String addEmp(){
        return "admin/addEmployee";
    }
}
