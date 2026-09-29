package com.symplifica.employee_api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @Column(name="employee_first_name", nullable = false)
    private String employeeFirstName;

    @Column(name="employee_second_name", nullable = false)
    private String employeeSecondName;

    @Column(name="employee_first_last_name", nullable = false)
    private String employeeFirstLastName;

    @Column(name="employee_second_last_name", nullable = false)
    private String employeeSecondLastName;

    @Column(name="email")
    private String email;

    @Column(name="city")
    private String city;

    @Column(name="creation_date")
    private LocalDateTime creationDate;
}