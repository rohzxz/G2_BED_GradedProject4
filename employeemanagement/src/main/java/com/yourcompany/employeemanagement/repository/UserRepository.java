package com.yourcompany.employeemanagement.repository;

// UserRepository.java

import com.yourcompany.employeemanagement.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
