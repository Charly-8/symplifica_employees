package com.symplifica.employee_api.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmpleado;

    @Column(name="nombre_beneficio", nullable = false)
    private String nombreBeneficio;

    @Column(name="monto", nullable = false, scale = 2)
    private BigDecimal monto;

    // Getters

    public Long getId() {
        return this.idEmpleado;
    }

    public String getNombreBeneficio() {
        return this.nombreBeneficio;
    }

    public BigDecimal getMonto() {
        return this.monto;
    }

    // Setters

    public void setNombreBeneficio(String nombreBeneficio) {
        this.nombreBeneficio = nombreBeneficio;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }
}