package com.yourcompany.employeemanagement.repository;

// EmployeeRepository.java

import com.yourcompany.employeemanagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // You can add custom query methods if needed

    // Example: Find employees by first name
    List<Employee> findByFirstName(String firstName);
}
