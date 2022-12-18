package employee_management.database;

import employee_management.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDB {
    public static ArrayList<Employee> employees = new ArrayList<>(List.of(
            new Employee(1, "Nguyễn Văn A", "a@gmail.com", 7_000_000),
            new Employee(2, "Trần Văn B", "b@gmail.com", 15_000_000),
            new Employee(3, "Huỳnh Văn C", "c@gmail.com", 8_600_000),
            new Employee(4, "Đỗ Thị D", "d@gmail.com", 4_000_000),
            new Employee(5, "Ngô Văn E", "e@gmail.com", 20_000_000),
            new Employee(6, "Bùi Thị F", "f@gmail.com", 9_000_000)
    ));
}
