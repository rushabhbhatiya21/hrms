package com.example.hrms.repositories;

import com.example.hrms.models.emploment_info.Designation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesignationRepository extends JpaRepository<Designation, Long> {
}
