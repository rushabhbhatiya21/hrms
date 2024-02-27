package com.example.hrms.repositories;

import com.example.hrms.models.emploment_info.Personal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonalRepository extends JpaRepository<Personal, Long> {
    Optional<Personal> findPersonalByEmployeeEmployeeId(Long employee_employeeId);
}
