package com.example.hrms.repositories.employment_info;

import com.example.hrms.models.employment_info.BankDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<BankDetail, Long> {

}
