package com.example.hrms.repositories;

import com.example.hrms.models.emploment_info.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    Optional<Contact> findContactByEmployeeEmployeeId(Long employee_employeeId);
}
