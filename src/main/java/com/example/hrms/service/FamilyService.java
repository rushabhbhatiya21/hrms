package com.example.hrms.service;

import com.example.hrms.models.emploment_info.Family;
import com.example.hrms.repositories.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamilyService {
    private final FamilyRepository familyRepository;

    @Autowired
    public FamilyService(FamilyRepository familyRepository) {
        this.familyRepository = familyRepository;
    }

    public void saveFamilies(List<Family> families) {
        familyRepository.saveAll(families);
    }

    public List<Family> findAllFamiliesByNominee(Long empId) {
        return familyRepository.findAllFamiliesWithNomineeAndEmployeeId(empId);
    }

    public List<Family> findFamiliesById(Long empId) {
        return familyRepository.findAllByEmployeeEmployeeId(empId);
    }
}
