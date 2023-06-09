package com.example.demojpa.mapper;

import com.example.demojpa.dto.EmployeeDto;
import com.example.demojpa.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto toEmployeeDto(Employee employee) {
        return EmployeeDto.builder()
                .id(employee.getId())
                .name(employee.getName())
                .email(employee.getEmail())
                .build();
    }
}
