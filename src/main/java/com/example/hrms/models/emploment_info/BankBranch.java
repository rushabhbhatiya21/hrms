package com.example.hrms.models.emploment_info;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "bankBranch")
public class BankBranch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bankBranchId;

    private String bankBranchName;

    private String ifscCode;

    @ManyToOne
    @JoinColumn(referencedColumnName = "bankId", name = "bankId")
    private BankDetail bank;
}
