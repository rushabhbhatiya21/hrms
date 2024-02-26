package com.example.hrms.models.emploment_info;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "personal")
public class Personal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personalId;

    private Gender gender;

    public enum Gender {
        MALE, FEMALE, OTHER
    }

    private MarriageStatus marriageStatus;

    public enum MarriageStatus {
        SINGLE, MARRIED, DIVORCED, SEPARATED, WIDOWED
    }

    private Date dateOfBirth;

    private Date dateOfMarriage;

    private String birthPlace;

    private CommunityCategory communityCategory;

    public enum CommunityCategory {
        OPEN, OBC, SC, ST
    }

    private String uidNumber;

    private String gpfAccountNumber;

    private String religion;

    private String caste;

    private String communityCategoryReference;

    private String nationality;

    private String insurancePolicyNumber;

    private String hobbies;

    private String bankAccountNumber;

    private String bsrCode;

    @ManyToOne
    @JoinColumn(referencedColumnName = "bankBranchId", name = "bankBranchId")
    private BankBranch bankDetail;

    private String passportNumber;

    private Date passportDateOfExpiry;

    private String visaDetails;

    private String drivingLicenceNumber;

    private VehicleType vehicleType;

    public enum VehicleType {
        TWO_WHEELER, FOUR_WHEELER
    }

    private Date drivingLicenceValidUpto;

    private String issuedState;

    private boolean isGovVehicleProvided;

    private boolean isGovVehicleUsedOnDuty;

    private boolean isResidentOfCountry;

    private Date migrationDate;

    private String country;

    private String countryAddress;

    private boolean isAnyProceedings;

    private String additionalInfo;

    @OneToOne
    @JoinColumn(referencedColumnName = "employeeId", name = "employeeId")
    private Employee employee;
}
