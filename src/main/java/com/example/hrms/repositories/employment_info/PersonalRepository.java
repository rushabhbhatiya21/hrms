package com.example.hrms.repositories.employment_info;

import com.example.hrms.models.employment_info.Personal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonalRepository extends JpaRepository<Personal, Long> {
    Optional<Personal> findPersonalByEmployeeEmployeeId(Long employee_employeeId);
}
