package com.example.hrms.models.employment;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "employmentCategory")
public class EmploymentCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employmentCategoryId;

    private String employmentCategoryName;

//    @ManyToOne
//    @JoinColumn(referencedColumnName = "employeeTypeId", name = "employeeTypeId")
//    private EmploymentType employeeType;
}
