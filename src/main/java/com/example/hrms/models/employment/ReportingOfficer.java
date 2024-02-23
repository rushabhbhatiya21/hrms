package com.example.hrms.models.employment;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "reportingOfficer")
public class ReportingOfficer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportingOfficerId;

    private Date roStartDate;

    private Date roEndDate;

    private String ddo;

    private String dh;

    private String ho;

    private String hod;

    private Date authorizationDate;

    private String note;

    @ManyToOne
    @JoinColumn(referencedColumnName = "employmentTypeId", name = "employmentTypeId")
    private EmploymentType employeeType;
}
