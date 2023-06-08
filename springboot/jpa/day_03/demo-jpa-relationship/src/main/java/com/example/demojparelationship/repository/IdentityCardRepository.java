package com.example.demojparelationship.repository;

import com.example.demojparelationship.entity.IdentityCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdentityCardRepository extends JpaRepository<IdentityCard, Integer> {
}