package com.example.hrms.service.employment_info;

import com.example.hrms.models.employment_info.BankDetail;
import com.example.hrms.repositories.employment_info.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankService {
    private final BankRepository bankRepository;

    @Autowired
    public BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public List<BankDetail> findAllBanks() {
        return bankRepository.findAll();
    }

    public Optional<BankDetail> findBankById(Long bankId) {
        return bankRepository.findById(bankId);
    }
}
