package com.example.hrms.repositories.employment_info;

import com.example.hrms.models.employment_info.BankBranch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BankBranchRepository extends JpaRepository<BankBranch, Long> {
    Optional<BankBranch> findBankBranchByBank_BankId(Long bank_bankId);
}
