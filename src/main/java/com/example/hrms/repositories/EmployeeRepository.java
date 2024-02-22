package com.example.hrms.repositories;


import com.example.hrms.models.emploment_info.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT MAX(employeeCode) FROM Employee")
    Long getNextEmployeeCode();
}
