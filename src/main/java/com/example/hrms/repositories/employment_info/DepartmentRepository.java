package com.example.hrms.repositories.employment_info;

import com.example.hrms.models.employment_info.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
