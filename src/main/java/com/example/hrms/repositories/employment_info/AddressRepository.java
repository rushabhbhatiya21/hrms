package com.example.hrms.repositories.employment_info;

import com.example.hrms.models.employment_info.AddressDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressDetail, Long> {
}
