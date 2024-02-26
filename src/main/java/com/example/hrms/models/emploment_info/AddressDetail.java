package com.example.hrms.models.emploment_info;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "address")
public class AddressDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    private String addressType;

    private String address;

    private String country;

    private String state;

    private String city;

    private String pinCode;

    private PropertyType propertytype;
    public enum PropertyType {
        OWNER, TENANT
    }

    private boolean areAllAddressSame;

//    @ManyToOne
//    @JoinColumn(referencedColumnName = "employeeId", name = "employeeId")
//    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "contactId")
    private Contact contact;
}
