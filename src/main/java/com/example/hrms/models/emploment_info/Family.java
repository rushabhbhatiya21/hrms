package com.example.hrms.models.emploment_info;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "family")
public class Family {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long familyId;

    private String firstName;

    private String middleName;

    private String lastName;

    private String relation;

    private Date dateOfBirth;

    private Personal.Gender gender;

    private boolean isNominee;

    private boolean isDependant;

    private boolean isResidingWith;

    private boolean canContactInEmergency;

    private boolean isDisabled;

    private Personal.MarriageStatus marriageStatus;

    private String occupation;

    private String contactDetail;

    private String nationality;

    private String address;

    @ManyToOne
    @JoinColumn(referencedColumnName = "employeeId", name = "employeeId")
    private Employee employee;
}
