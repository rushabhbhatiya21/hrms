package com.example.hrms.models.employment;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "employmentType")
public class EmploymentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employmentTypeId;

    private String employmentTypeName;

    @ManyToOne
    @JoinColumn(referencedColumnName = "employmentCategoryId", name = "employmentCategoryId")
    private EmploymentCategory employmentCategory;
}
