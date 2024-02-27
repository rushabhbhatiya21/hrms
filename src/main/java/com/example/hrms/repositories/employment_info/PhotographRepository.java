package com.example.hrms.repositories.employment_info;

import com.example.hrms.models.employment_info.Photograph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PhotographRepository extends JpaRepository<Photograph, Long> {
    Optional<Photograph> findPhotographByEmployeeEmployeeId(Long employee_employeeId);
}
