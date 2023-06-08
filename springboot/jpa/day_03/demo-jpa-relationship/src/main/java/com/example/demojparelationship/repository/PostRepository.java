package com.example.demojparelationship.repository;

import com.example.demojparelationship.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}