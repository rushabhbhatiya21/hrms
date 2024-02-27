package com.example.hrms.service.employment_info;

import com.example.hrms.models.employment_info.Health;
import com.example.hrms.repositories.employment_info.HealthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HealthService {
    private final HealthRepository healthRepository;

    @Autowired
    public HealthService(HealthRepository healthRepository) {
        this.healthRepository = healthRepository;
    }

    public Optional<Health> findHealthByEmpId(Long empId) {
        return healthRepository.findHealthByEmployeeEmployeeId(empId);
    }

    public void saveHealth(Health health) {
        healthRepository.save(health);
    }
}
