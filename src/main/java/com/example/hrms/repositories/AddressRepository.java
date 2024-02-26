package com.example.hrms.repositories;

import com.example.hrms.models.emploment_info.AddressDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressDetail, Long> {
}
