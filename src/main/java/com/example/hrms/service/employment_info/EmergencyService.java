package com.example.hrms.service.employment_info;

import com.example.hrms.models.employment_info.Emergency;
import com.example.hrms.repositories.employment_info.EmergencyRepository;
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

    public List<Emergency> findAllById(Long empId) {
        return emergencyRepository.findAllByEmployeeEmployeeId(empId);
    }
}
