package com.avp.management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "departments")
@Getter @Setter
@NoArgsConstructor
public class Department extends BaseAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    /**
     * Link back to the Company.
     * Many departments belong to one company.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    /**
     * manager_id is stored as a Long to avoid circular dependency issues
     * during initial setup, or you can map it as a @OneToOne to an Employee.
     */
    @Column(name = "manager_id")
    private Long managerId;

    /**
     * List of employees working in this department.
     */
    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    private List<Employee> employees;
}