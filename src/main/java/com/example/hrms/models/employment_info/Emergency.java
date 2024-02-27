package com.example.hrms.models.employment_info;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "emergency")
public class Emergency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long emergencyContactId;

    private Integer priority;

    private String firstName;

    private String middleName;

    private String lastName;

    private String relation;

    private String phoneNumber;

    private String mobileNumber;

    private String email;

    private String address;

    @ManyToOne
    @JoinColumn(referencedColumnName = "employeeId", name = "employeeId")
    private Employee employee;
}
