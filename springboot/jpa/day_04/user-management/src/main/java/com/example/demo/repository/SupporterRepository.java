package com.example.demo.repository;

import com.example.demo.model.Supporter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupporterRepository extends JpaRepository<Supporter, Integer> {
}