package abstract_class;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
abstract public class Employee {
    private int id;
    private String name;
    private int age;
    private int salaryBasic;

    // Điểm danh
    public void register() {
        System.out.println("Register ...");
    }

    // Tính lương
    abstract public int calculateSalary();

    // In thông tin của nhân viên
    abstract void showInfo();
}
