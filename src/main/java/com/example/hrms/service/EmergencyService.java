package com.example.hrms.service;

import com.example.hrms.models.emploment_info.Emergency;
import com.example.hrms.repositories.EmergencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmergencyService {
    private final EmergencyRepository emergencyRepository;

    @Autowired
    public EmergencyService(EmergencyRepository emergencyRepository) {
        this.emergencyRepository = emergencyRepository;
    }

    public void saveEmergencyContacts(List<Emergency> emergencyList) {
        emergencyRepository.saveAll(emergencyList);
    }
}
