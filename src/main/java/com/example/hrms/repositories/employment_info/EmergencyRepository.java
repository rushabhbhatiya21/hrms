package com.example.hrms.repositories.employment_info;

import com.example.hrms.models.employment_info.Emergency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmergencyRepository extends JpaRepository<Emergency, Long> {
    List<Emergency> findAllByEmployeeEmployeeId(Long employee_employeeId);
}
