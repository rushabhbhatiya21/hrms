package com.example.hrms.service.employment_info;

import com.example.hrms.models.employment_info.Department;
import com.example.hrms.repositories.employment_info.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Department> findDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId);
    }
}
