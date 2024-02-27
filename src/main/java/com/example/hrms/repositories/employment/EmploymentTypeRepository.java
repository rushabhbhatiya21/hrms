package com.example.hrms.repositories.employment;

import com.example.hrms.models.employment.EmploymentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmploymentTypeRepository extends JpaRepository<EmploymentType, Long> {
}
