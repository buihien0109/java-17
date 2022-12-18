package abstract_class;

import java.util.ArrayList;
import java.util.Comparator;

public class Test {
    public static void main(String[] args) {
//        Employee employee2 = new Employee() {
//            @Override
//            public int calculateSalary() {
//                return 0;
//            }
//        }
        Employee employee = new Developer(1, "Nguyễn Văn A", 24, 5_000_000, 40);
        System.out.println(employee.calculateSalary());

        Employee employee1 = new Tester(2, "Trần Văn B", 27, 10_000_000, 10);
        System.out.println(employee1.calculateSalary());

        // Tạo 1 ds nhân viên
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(employee);
        employees.add(employee1);
        employees.add(new Developer(3, "Ngộ Thị C", 30, 8_000_000, 20));
        employees.add(new Tester(4, "Đỗ Văn D", 20, 6_000_000, 50));

        System.out.println("Lương của từng nhân viên");
        for (Employee e: employees) {
            System.out.println(e.calculateSalary());
        }

        // Sắp xếp theo lương giảm dần
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                // 1, 0, -1
                return o2.calculateSalary() - o1.calculateSalary();
            }
        });

        System.out.println("Lương giảm dần");
        for (Employee e: employees) {
            e.showInfo();
        }

        // Sắp xếp tuổi tăng dần
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                // 1, 0, -1
                return o1.getAge() - o2.getAge();
            }
        });

        System.out.println("Tuổi tăng dần");
//        for (Employee e: employees) {
//            e.showInfo();
//        }

        // method reference
        // employees.forEach(Employee::showInfo);

        // lambda expression
        employees.forEach(e -> e.showInfo());

        // Sử dụng stream (demo)
        // stream, method reference, lambda expression (java 8)
        System.out.println("Lương cơ bản tăng dần");
        employees.stream()
                .sorted(Comparator.comparingInt(Employee::getSalaryBasic))
                .forEach(Employee::showInfo);

    }
}
