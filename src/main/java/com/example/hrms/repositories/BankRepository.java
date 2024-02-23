package com.example.hrms.repositories;

import com.example.hrms.models.emploment_info.BankBranch;
import com.example.hrms.models.emploment_info.BankDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BankRepository extends JpaRepository<BankDetail, Long> {

}
