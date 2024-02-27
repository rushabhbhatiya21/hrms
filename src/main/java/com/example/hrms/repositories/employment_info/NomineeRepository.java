package com.example.hrms.repositories.employment_info;

import com.example.hrms.models.employment_info.Nominee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NomineeRepository extends JpaRepository<Nominee, Long> {
    List<Nominee> findAllByEmployeeEmployeeId(Long employee_employeeId);
}
