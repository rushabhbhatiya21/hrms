package com.example.hrms.repositories;

import com.example.hrms.models.emploment_info.BankBranch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BankBranchRepository extends JpaRepository<BankBranch, Long> {
    Optional<BankBranch> findBankBranchByBank_BankId(Long bank_bankId);
}
