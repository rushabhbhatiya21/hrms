package com.example.hrms.models.employment_info;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @Column(unique = true)
    private Long employeeCode;

    @Column(unique = true)
    private String panNumber;

    private Long oldEmployeeCode;

    private Date dateOfAppointment;

    private String bioMetricId;

    private String salutation;

//    public enum Salutation {
//        MR, MRS, MISS, SHRIMAN, SHRIMATI, DR, KUMARI
//    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "departmentId", name = "departmentId")
    private Department department;

    private String firstName;

    private String middleName;

    private String lastName;

    private String unit;

    @ManyToOne
    @JoinColumn(referencedColumnName = "designationId", name = "designationId")
    private Designation designation;

    @ManyToOne
    @JoinColumn(referencedColumnName = "groupMainId", name = "groupMainId")
    private GroupMain groupMain;

    private String employeeEligibleFor;

    private boolean isUnderGratuityAct;
}
