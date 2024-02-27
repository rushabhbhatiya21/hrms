package com.example.hrms.service.employment;

import com.example.hrms.models.employment.EmploymentType;
import com.example.hrms.repositories.employment.EmploymentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmploymentTypeService {
    private final EmploymentTypeRepository employmentTypeRepository;

    @Autowired
    public EmploymentTypeService(EmploymentTypeRepository employmentTypeRepository) {
        this.employmentTypeRepository = employmentTypeRepository;
    }

    public List<EmploymentType> findAllEmploymentTypes() {
        return employmentTypeRepository.findAll();
    }
}
