package com.avp.management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "salary_structures")
@Getter
@Setter
@NoArgsConstructor
public class SalaryStructure extends BaseAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", unique = true, nullable = false)
    private Employee employee;

    private BigDecimal baseSalary;
    private BigDecimal hra;
    private BigDecimal allowances;
    private BigDecimal deductions;
}