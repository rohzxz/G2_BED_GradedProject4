package com.yourcompany.employeemanagement.model;

// Role.java

import jakarta.persistence.Entity;

import javax.persistence.*;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Getters and setters
}
