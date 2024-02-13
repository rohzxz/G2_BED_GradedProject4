package com.yourcompany.employeemanagement.service;

// EmployeeService.java


import com.yourcompany.employeemanagement.model.Employee;
import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);

    Employee createEmployee(Employee employee);

    Employee updateEmployee(Long id, Employee updatedEmployee);

    void deleteEmployee(Long id);

    List<Employee> searchEmployeesByFirstName(String firstName);

    List<Employee> getAllEmployeesSorted(String order);
}

