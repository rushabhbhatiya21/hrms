package com.example.hrms.service;

import com.example.hrms.models.emploment_info.Photograph;
import com.example.hrms.repositories.PhotographRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PhotographService {
    private final PhotographRepository photographRepository;

    @Autowired
    public PhotographService(PhotographRepository photographRepository) {
        this.photographRepository = photographRepository;
    }

    public void savePhotograph(Photograph photo) {
        photographRepository.save(photo);
    }

    public Optional<Photograph> findPhotographByEmpId(Long empId) {
        return photographRepository.findPhotographByEmployeeEmployeeId(empId);
    }
}
