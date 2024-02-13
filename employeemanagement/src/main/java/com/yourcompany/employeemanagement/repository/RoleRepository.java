package com.yourcompany.employeemanagement.repository;

// RoleRepository.java

import com.yourcompany.employeemanagement.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
