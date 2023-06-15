package com.example.demo.repository;

import com.example.demo.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Integer> {
}