package com.yourcompany.employeemanagement.service;

// UserService.java

import com.yourcompany.employeemanagement.model.User;
import com.yourcompany.employeemanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Implement your service methods for user-related operations
}
