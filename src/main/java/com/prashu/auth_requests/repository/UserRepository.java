package com.prashu.auth_requests.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prashu.auth_requests.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

