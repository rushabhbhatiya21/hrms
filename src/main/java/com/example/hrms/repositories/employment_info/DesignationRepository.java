package com.example.hrms.repositories.employment_info;

import com.example.hrms.models.employment_info.Designation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesignationRepository extends JpaRepository<Designation, Long> {
}
