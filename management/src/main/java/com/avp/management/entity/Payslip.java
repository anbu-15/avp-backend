package com.avp.management.entity;

import com.avp.management.enums.PayslipStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "payslips")
@Getter
@Setter
@NoArgsConstructor
public class Payslip extends BaseAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    private Integer payrollMonth;
    private Integer payrollYear;
    private BigDecimal netAmount;

    @Enumerated(EnumType.STRING)
    private PayslipStatus status = PayslipStatus.DRAFT;
}