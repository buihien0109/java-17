package com.example.demojpa;

import com.example.demojpa.dto.EmployeeDto;
import com.example.demojpa.entity.Employee;
import com.example.demojpa.mapper.EmployeeMapper;
import com.example.demojpa.repository.EmployeeRepository;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
public class EmployeeTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private Faker faker;

    @Test
    void save_em() {
        for (int i = 0; i < 10; i++) {
            Employee employee = Employee.builder()
                    .name(faker.name().fullName())
                    .email(faker.internet().emailAddress())
                    .password("111")
                    .build();
            employeeRepository.save(employee);
        }
    }

    @Test
    void query_dto_mapper() {
        List<Employee> employeeList = employeeRepository.findAll();
        List<EmployeeDto> employeeDtoList = employeeList.stream()
                .map(employee -> EmployeeMapper.toEmployeeDto(employee))
                .collect(Collectors.toList());

        employeeDtoList.forEach(System.out::println);
    }

    @Test
    void query_dto_3rd() {
        ModelMapper mapper = new ModelMapper();

        List<Employee> employeeList = employeeRepository.findAll();
        List<EmployeeDto> employeeDtoList = employeeList.stream()
                .map(employee -> mapper.map(employee, EmployeeDto.class))
                .collect(Collectors.toList());

        employeeDtoList.forEach(System.out::println);
    }

    @Test
    void query_dto_jpql() {
        EmployeeDto employeeDto = employeeRepository.getEmployeeDtoByEmail("gary.corkery@gmail.com");
        System.out.println(employeeDto);
    }

    @Test
    void query_dto_native() {
        EmployeeDto employeeDto = employeeRepository.getEmployeeDtoUsingNQ("gary.corkery@gmail.com");
        System.out.println(employeeDto);
    }
}
