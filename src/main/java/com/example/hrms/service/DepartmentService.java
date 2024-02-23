package com.example.hrms.service;

import com.example.hrms.models.emploment_info.Department;
import com.example.hrms.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> findALlDepartments() {
        return departmentRepository.findAll();
    }
}