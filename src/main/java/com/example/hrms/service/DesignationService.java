package com.example.hrms.service;

import com.example.hrms.models.emploment_info.Designation;
import com.example.hrms.repositories.DesignationRepository;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DesignationService {
    private final DesignationRepository designationRepository;

    @Autowired
    public DesignationService(DesignationRepository designationRepository) {
        this.designationRepository = designationRepository;
    }
    public List<Designation> findAllDesignations() {
        return designationRepository.findAll();
    }

    public Optional<Designation> findDesignationById(Long designationId) {
        return designationRepository.findById(designationId);
    }
}
