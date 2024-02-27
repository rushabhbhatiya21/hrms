package com.example.hrms.repositories.employment;

import com.example.hrms.models.employment.EmploymentCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmploymentCategoryRepository extends JpaRepository<EmploymentCategory, Long> {
}
