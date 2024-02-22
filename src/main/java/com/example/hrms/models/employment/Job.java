package com.example.hrms.models.employment;

import com.example.hrms.models.emploment_info.Designation;
import com.example.hrms.models.emploment_info.Employee;
import com.example.hrms.models.emploment_info.GroupMain;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "job")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobId;

    @ManyToOne
    @JoinColumn(referencedColumnName = "employmentTypeId", name = "employmentTypeId")
    private EmploymentType employmentType;

    private EmploymentSubType employmentSubType;

    public enum EmploymentSubType {
        AD_HOC, PROBATIONER
    }

    private EmploymentStatus employmentStatus;

    public enum EmploymentStatus {
        ACTIVE, INACTIVE
    }

    private Integer noticePeriod;

    private String employeeGrade;

    private String probationDuration;

    private String trainingDuration;

    private Date probationStartDate;

    private Date trainingStartDate;

    private String dutiesAndResponsibility;

    @ManyToOne
    @JoinColumn(referencedColumnName = "groupId", name = "groupId")
    private GroupMain insuranceStartGroup;

    private Date startGroupEffectiveFrom;

    // --------------------------- INITIAL JOINING DETAILS ------------------------- //

    @ManyToOne
    @JoinColumn(referencedColumnName = "placeOfPostingId", name = "placeOfPostingId")
    private PlaceOfPosting placeOfPosting;

    private String workLocation;

    @ManyToOne
    @JoinColumn(referencedColumnName = "designationId", name = "designationId")
    private Designation designation;

    private Date dateOfPosting;

    private String postingOrderNumber;

    private Date dateOfPostingOrder;

    private String payConfiguration;

    private String scale;

    private String scaleValue;

    private String gradePay;

    // ----------------------------------- RECRUITMENT ---------------------------------------- //
    private RecruitmentType recruitmentType;

    public enum RecruitmentType {
        INTERNAL, OTHER
    }

    private String otherRecruitmentType;

    private String shift;

    private Date weeklyOffEffectiveFrom;

    private String weeklyOff;

    @OneToOne
    @JoinColumn(referencedColumnName = "employeeId", name = "employeeId")
    private Employee employee;
}