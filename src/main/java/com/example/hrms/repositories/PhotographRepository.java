package com.example.hrms.repositories;

import com.example.hrms.models.emploment_info.Photograph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotographRepository extends JpaRepository<Photograph, Long> {
}
