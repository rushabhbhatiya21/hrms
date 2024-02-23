package com.example.hrms.service;

import com.example.hrms.models.emploment_info.BankBranch;
import com.example.hrms.repositories.BankBranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankBranchService {
    private final BankBranchRepository bankBranchRepository;

    @Autowired
    public BankBranchService(BankBranchRepository bankBranchRepository) {
        this.bankBranchRepository = bankBranchRepository;
    }

    public List<BankBranch> findAllBankBranches() {
        return bankBranchRepository.findAll();
    }

    public Optional<BankBranch> findBankBranchById(Long bankBranchId) {
        return bankBranchRepository.findById(bankBranchId);
    }

    public Optional<BankBranch> findBankBranchByBankId(Long bankId) {
        return bankBranchRepository.findBankBranchByBank_BankId(bankId);
    }
}
