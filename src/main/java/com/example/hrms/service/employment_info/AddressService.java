package com.example.hrms.service.employment_info;

import com.example.hrms.models.employment_info.AddressDetail;
import com.example.hrms.repositories.employment_info.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public void saveAddresses(List<AddressDetail> addresses) {
        addressRepository.saveAll(addresses);
    }
}
