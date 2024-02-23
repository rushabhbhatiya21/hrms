package com.example.hrms.models.emploment_info;

import com.example.hrms.models.employment.Job;
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
