package com.example.demojpa.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class EmployeeDto {
    private Integer id;
    private String name;
    private String email;
}

// C1: Query Entity -> Mapper -> Dto
// Mapper có thể tự viết, sử dụng thư viện : Object Mapper, MapStruct
// C2 : JPQL
// C3 : Native Query
// C4 : Sử dụng Projection (interface) -> tự tìm hiểu
