package com.example.hrms.models.qualification;

import com.example.hrms.models.emploment_info.Employee;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Month;
import java.time.Year;

@Entity
@Getter
@Setter
@Table(name = "educationQualification")
public class EducationQualification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long educationId;

    private String qualification;

    private String modeOfStudy;

    private String university;

    private Month passingMonth;

    private Year passingYear;

    private String institute;

    private String duration;

    private String major;

    private String percentage;

    private String grade;

    private String percentile;

    private String gpaScore;

    private String remark;

    private String instituteAddress;

    @OneToOne
    @JoinColumn(referencedColumnName = "employeeId", name = "employeeId")
    private Employee employee;
}
