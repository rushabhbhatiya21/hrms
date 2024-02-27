package com.example.hrms.repositories;

import com.example.hrms.models.emploment_info.Health;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HealthRepository extends JpaRepository<Health, Long> {
    Optional<Health> findHealthByEmployeeEmployeeId(Long employee_employeeId);
}
