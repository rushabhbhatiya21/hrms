package com.example.hrms.models.emploment_info;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @Column(unique = true)
    private Long code;

    @Column(unique = true)
    private Long panNumber;

    private Long oldEmployeeCode;

    private Date dateOfAppointment;

    private String bioMetricId;

    private Salutation salutation;
    public enum Salutation {
        MR, MRS, MISS, SHRIMAN, SHRIMATI, DR
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "departmentId", name = "departmentId")
    private Department department;

    private String firstName;

    private String middleName;

    private String lastName;

    private String unit;

//    @ManyToOne
//    @JoinColumn(referencedColumnName = "designationId", name = "designationId")
//    private Designation designation;

//    @ManyToOne
//    @JoinColumn(referencedColumnName = "deignationId", name = "designationId")
//    private GroupMain groupMain;

    private String employeeEligibleFor;

    private boolean isUnderGratuityAct;
}
