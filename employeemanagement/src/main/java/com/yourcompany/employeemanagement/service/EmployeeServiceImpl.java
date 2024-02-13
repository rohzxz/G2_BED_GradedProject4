package com.yourcompany.employeemanagement.service;
// EmployeeServiceImpl.java

import com.yourcompany.employeemanagement.model.Employee;
import com.yourcompany.employeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        // Implement update logic
        return null;
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> searchEmployeesByFirstName(String firstName) {
        // Implement search logic
        return null;
    }

    @Override
    public List<Employee> getAllEmployeesSorted(String order) {
        // Implement sorting logic
        return null;
    }
}
