package com.example.hrms.service;

import com.example.hrms.models.emploment_info.GroupMain;
import com.example.hrms.repositories.GroupRepository;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {
    private final GroupRepository groupRepository;

    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<GroupMain> findAllGroups() {
        return groupRepository.findAll();
    }

    public Optional<GroupMain> findGroupById(Long groupId) {
        return groupRepository.findById(groupId);
    }
}
