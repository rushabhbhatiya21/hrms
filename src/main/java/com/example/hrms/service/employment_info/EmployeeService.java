package com.example.hrms.service.employment_info;

import com.example.hrms.models.employment_info.Employee;
import com.example.hrms.repositories.employment_info.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Optional<Employee> findEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId);
    }

    public Long getNextEmployeeCode() {
        Long maxEmployeeCode = employeeRepository.getNextEmployeeCode();
        if (maxEmployeeCode == null) {
            return 1L;
        }
        return maxEmployeeCode + 1;
    }

    public List<Employee> searchEmployeesByFirstName(String firstName) {
        return employeeRepository.findAllByFirstNameContainingIgnoreCase(firstName);
    }
}
