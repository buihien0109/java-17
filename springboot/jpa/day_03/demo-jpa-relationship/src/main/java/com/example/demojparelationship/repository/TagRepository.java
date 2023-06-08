package com.example.demojparelationship.repository;

import com.example.demojparelationship.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Integer> {
}