package com.example.hrms.service;

import com.example.hrms.models.emploment_info.AddressDetail;
import com.example.hrms.models.emploment_info.Contact;
import com.example.hrms.repositories.AddressRepository;
import com.example.hrms.repositories.ContactRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {
    private final ContactRepository contactRepository;
    private final AddressRepository addressRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository, AddressRepository addressRepository) {
        this.contactRepository = contactRepository;
        this.addressRepository = addressRepository;
    }

    @Transactional
    public void saveContact(Contact contact) {
        List<AddressDetail> addresses = contact.getAddresses();

        for (AddressDetail address : addresses) {
            address.setContact(contact);
        }

        addressRepository.saveAll(addresses);
        contactRepository.save(contact);
    }

    public Optional<Contact> findContactByEmpId(Long empId) {
        return contactRepository.findContactByEmployeeEmployeeId(empId);
    }
}
