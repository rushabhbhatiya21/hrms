package com.example.hrms.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDTO {
    private String username;
    private String password;
    private Long employeeId;
}
