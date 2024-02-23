package com.example.hrms.repositories;

import com.example.hrms.models.emploment_info.Personal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalRepository extends JpaRepository<Personal, Long> {
}
