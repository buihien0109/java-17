package com.example.demojparelationship.repository;

import com.example.demojparelationship.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}