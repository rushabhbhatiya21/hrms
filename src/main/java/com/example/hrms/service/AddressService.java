package com.example.hrms.service;

import com.example.hrms.models.emploment_info.AddressDetail;
import com.example.hrms.repositories.AddressRepository;
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
