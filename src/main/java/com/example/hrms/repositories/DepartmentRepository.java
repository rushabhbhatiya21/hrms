package com.example.hrms.repositories;

import com.example.hrms.models.emploment_info.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
