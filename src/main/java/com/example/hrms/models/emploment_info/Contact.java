package com.example.hrms.models.emploment_info;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contactId;

    private String workPhone;

    private String extension;

    private String workMobile;

    private String homePhone;

    private String homeMobile;

    private String corporateEmail;

    private String personalEmail;

    private String secondaryEmail;

    @ManyToOne
    @JoinColumn(referencedColumnName = "addressId", name = "addressId")
    private AddressDetail address;

    @OneToOne
    @JoinColumn(referencedColumnName = "employeeId", name = "employeeId")
    private Employee employee;
}
