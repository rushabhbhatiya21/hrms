package com.example.hrms.models.employment_info;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "groupMain")
public class GroupMain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupMainId;

    private String groupName;
}
