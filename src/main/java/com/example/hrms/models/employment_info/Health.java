package com.example.hrms.models.employment_info;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "health")
public class Health {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long healthId;

    private Integer height;

    private Integer weight;

    private String bloodGroup;

    private String idMark1;

    private String idMark2;

    private boolean isHandicapped;

    @OneToOne
    @JoinColumn(referencedColumnName = "employeeId", name = "employeeId")
    private Employee employee;
}
