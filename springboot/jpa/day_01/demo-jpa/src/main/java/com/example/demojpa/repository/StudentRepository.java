package com.example.demojpa.repository;

import com.example.demojpa.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    // Sử dụng method query
    // Tìm kiếm theo tên và phân trang
    Page<Student> findByName(String name, Pageable pageable);

    List<Student> findByNameOrderByNameDesc(String name); // Nhanh nhất
    List<Student> findByName(String name, Sort sort); // Áp dụng cho nhiều trường hợp sắp xếp khác nhau

    @Query(nativeQuery = true, value = "select * from student where name = ?1 order by name desc")
    List<Student> findByNameSort(String name);

    Page<Student> findByNameContainingIgnoreCase(String name, Pageable pageable);

    // Sử dụng native query
    @Query(
            nativeQuery = true,
            value = "select * from student",
            countQuery = "select count(id) from student"
    )
    Page<Student> getAllStudent(Pageable pageable);

    @Query(
            nativeQuery = true,
            value = "select * from student s where upper(s.name) like upper(concat('%', ?1, '%'))",
            countQuery = "select count(s.id) from student s where upper(s.name) like upper(concat('%', ?1, '%'))"
    )
    Page<Student> findByNameContainingIgnoreCaseUsingNQ(String name, Pageable pageable);
}