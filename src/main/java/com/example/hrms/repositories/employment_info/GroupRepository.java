package com.example.hrms.repositories.employment_info;

import com.example.hrms.models.employment_info.GroupMain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<GroupMain, Long> {
}
