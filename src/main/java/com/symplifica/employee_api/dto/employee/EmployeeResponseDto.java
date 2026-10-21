package com.symplifica.employee_api.dto.employee;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class EmployeeResponseDto {
    private Long id;
    private String firstName;
    private String secondName;
    private String firstLastName;
    private String secondLastName;
    private String email;
    private String city;
    private LocalDateTime Date;
}