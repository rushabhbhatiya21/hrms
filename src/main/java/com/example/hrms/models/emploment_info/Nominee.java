package com.example.hrms.models.emploment_info;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "nominee")
public class Nominee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nomineeId;

    private Integer priority;

    private String firstName;

    private String middleName;

    private String lastName;

    private String relation;

    private Personal.Gender gender;

    private Date dateOfBirth;

    @Column(unique = true)
    private String uidNumber;

    @Column(unique = true)
    private String panNumber;

    private String contactNumber;

    private String nomineeInvalidCondition;

    @ManyToOne
    @JoinColumn(referencedColumnName = "employeeId", name = "employeeId")
    private Employee employee;
}
