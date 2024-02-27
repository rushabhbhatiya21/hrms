package com.example.hrms.service;

import com.example.hrms.models.emploment_info.Attachment;
import com.example.hrms.repositories.AttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttachmentService {
    private final AttachmentRepository attachmentRepository;

    @Autowired
    public AttachmentService(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }

    public Optional<Attachment> findAttachmentByEmpId(Long empId) {
        return attachmentRepository.findAttachmentByEmployeeEmployeeId(empId);
    }

    public void saveAttachment(Attachment attachment) {
        attachmentRepository.save(attachment);
    }
}
