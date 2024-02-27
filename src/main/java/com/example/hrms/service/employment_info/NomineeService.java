package com.example.hrms.service.employment_info;

import com.example.hrms.models.employment_info.Nominee;
import com.example.hrms.repositories.employment_info.NomineeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NomineeService {
    private final NomineeRepository nomineeRepository;

    @Autowired
    public NomineeService(NomineeRepository nomineeRepository) {
        this.nomineeRepository = nomineeRepository;
    }

    public List<Nominee> findNomineesByEmpId(Long empId) {
        return nomineeRepository.findAllByEmployeeEmployeeId(empId);
    }

    public void saveNominees(List<Nominee> nominees) {
        nomineeRepository.saveAll(nominees);
    }
}
