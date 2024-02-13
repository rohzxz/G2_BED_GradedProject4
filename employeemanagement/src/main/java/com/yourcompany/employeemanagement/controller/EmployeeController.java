package com.yourcompany.employeemanagement.controller;

// EmployeeController.java
import com.yourcompany.employeemanagement.exception.ResourceNotFoundException;
import com.yourcompany.employeemanagement.model.Employee;
import com.yourcompany.employeemanagement.repository.EmployeeRepository;
import com.yourcompany.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Sort;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        return ResponseEntity.ok(employee);
    }

    @PostMapping
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @Valid @RequestBody Employee updatedEmployee) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        updatedEmployee.setId(employee.getId());
        updatedEmployee.setFirstName(employee.getFirstName());
        updatedEmployee.setLastName(employee.getLastName());
        updatedEmployee.setEmail(employee.getEmail());
        employeeRepository.save(updatedEmployee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
        employeeRepository.delete(employee);
        return ResponseEntity.ok("Deleted employee id - " + id);
    }

    @GetMapping("/search/{firstName}")
    public List<Employee> getEmployeesByFirstName(@PathVariable String firstName) {
        return employeeRepository.findByFirstName(firstName);
    }

    @GetMapping("/sort")
    public List<Employee> getEmployeesSorted(@RequestParam(defaultValue = "asc") String order) {
        if (order.equalsIgnoreCase("asc")) {
            return employeeRepository.findAll(Sort.by(Sort.Direction.ASC, "firstName"));
        } else {
            return employeeRepository.findAll(Sort.by(Sort.Direction.DESC, "firstName"));
        }
    }
}