package com.example.hrms.repositories.employment_info;


import com.example.hrms.models.employment_info.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<com.example.hrms.models.employment_info.Employee, Long> {
    @Query("SELECT MAX(employeeCode) FROM Employee")
    Long getNextEmployeeCode();

    List<Employee> findAllByFirstNameContainingIgnoreCase(String firstName);
}
