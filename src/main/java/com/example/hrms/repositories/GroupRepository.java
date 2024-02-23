package com.example.hrms.repositories;

import com.example.hrms.models.emploment_info.GroupMain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<GroupMain, Long> {
}
