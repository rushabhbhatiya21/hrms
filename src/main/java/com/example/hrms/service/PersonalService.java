package com.example.hrms.service;

import com.example.hrms.models.emploment_info.Personal;
import com.example.hrms.repositories.PersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonalService {
    private final PersonalRepository personalRepository;

    @Autowired
    public PersonalService(PersonalRepository personalRepository) {
        this.personalRepository = personalRepository;
    }

    public void savePersonal(Personal personal) {
        personalRepository.save(personal);
    }

    public Personal findPersonalByEmpId(Long empId) {
        Optional<Personal> p= personalRepository.findPersonalByEmployeeEmployeeId(empId);
        return p.orElse(null);
    }
}
