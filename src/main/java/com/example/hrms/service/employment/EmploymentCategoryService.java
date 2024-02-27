package com.example.hrms.service.employment;

import com.example.hrms.models.employment.EmploymentCategory;
import com.example.hrms.repositories.employment.EmploymentCategoryRepository;
import com.example.hrms.repositories.employment.EmploymentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmploymentCategoryService {
    private final EmploymentCategoryRepository employmentCategoryRepository;

    @Autowired
    public EmploymentCategoryService(EmploymentCategoryRepository employmentCategoryRepository) {
        this.employmentCategoryRepository = employmentCategoryRepository;
    }

    public List<EmploymentCategory> findAllEmploymentCategories() {
        return employmentCategoryRepository.findAll();
    }
}
