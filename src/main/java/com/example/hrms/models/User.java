package com.example.hrms.models;

import com.example.hrms.models.employment_info.Employee;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String username;

    private String password;

    @OneToOne
    @JoinColumn(referencedColumnName = "employeeId", name = "employeeId")
    private Employee employee;
}
