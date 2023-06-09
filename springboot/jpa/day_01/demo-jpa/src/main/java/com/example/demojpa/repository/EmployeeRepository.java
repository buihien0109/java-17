package com.example.demojpa.repository;

import com.example.demojpa.dto.EmployeeDto;
import com.example.demojpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("""
        select new com.example.demojpa.dto.EmployeeDto(e.id, e.name, e.email) 
        from Employee e
        where e.email = ?1
    """)
    EmployeeDto getEmployeeDtoByEmail(String email);

    @Query(nativeQuery = true, name = "getEmployeeDtoUsingNQ")
    EmployeeDto getEmployeeDtoUsingNQ(String email);
}