package com.example.hrms.repositories.employment_info;

import com.example.hrms.models.employment_info.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, Long> {
    Optional<Attachment> findAttachmentByEmployeeEmployeeId(Long employee_employeeId);
}
