package com.avp.management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
public class Role extends BaseAuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_name", unique = true, nullable = false)
    private String roleName;

    // Stores permissions as a JSON string
    @Column(columnDefinition = "json")
    private String permissions;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private List<Employee> employees;
}