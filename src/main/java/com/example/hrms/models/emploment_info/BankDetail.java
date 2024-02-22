package com.example.hrms.models.emploment_info;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "bank")
public class BankDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bankId;

    private String bankName;

    private String bankAccountNumber;

    private String ifscCode;

    private String bsrCode;

    @ManyToOne
    @JoinColumn(referencedColumnName = "bankBranchId", name = "bankBranchId")
    private BankBranch bankBranch;
}