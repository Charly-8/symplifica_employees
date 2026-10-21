package com.symplifica.employee_api.dto.employee;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class EmployeeRequestDto {
    private Long id;

    @NotBlank(message = "El primer nombre es obligatorio")
    @Size(min = 2, max = 50, message = "El primer nombre debe tener entre 2 y 50 caracteres")
    private String firstName;

    @Size(max = 50, message = "El segundo nombre no puede exceder 50 caracteres")
    private String secondName;

    @NotBlank(message = "El primer apellido es obligatorio")
    @Size(min = 2, max = 50, message = "El primer apellido debe tener entre 2 y 50 caracteres")
    private String firstLastName;

    @Size(max = 50, message = "El segundo apellido no puede exceder 50 caracteres")
    private String secondLastName;

    @NotBlank(message = "El correo electrónico es obligatorio")
    @Email(message = "Debe proporcionar un correo electrónico válido")
    private String email;

    @NotBlank(message = "La ciudad es obligatoria")
    private String city;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime date;
}