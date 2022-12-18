package employee_management.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Employee {
    private int id;
    private String name;
    private String email;
    private int salary;
}
