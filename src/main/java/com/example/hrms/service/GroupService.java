package com.example.hrms.service;

import com.example.hrms.models.emploment_info.GroupMain;
import com.example.hrms.repositories.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
