package com.example.demo.repository;

import com.example.demo.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    Page<Course> findByType(Pageable pageable, String type);

    List<Course> findByType(String type);
}