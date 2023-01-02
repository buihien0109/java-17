package method_reference;

import lombok.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@FunctionalInterface
interface IStudent {
    void display();
}

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
    private int id;
    private String name;
    private String email;

    public void printInfo() {

    }

    public static void main(String[] args) {
        // Triển khai functional interface
        Student student = new Student(1, "Bùi Hiên", "hiengmail.com");
        IStudent iStudent = student::printInfo;
        // IStudent iStudent1 = () -> student.printInfo();
        iStudent.display();

        // Tham chiếu đến method của 1 instance
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Bùi Hiên", "hiengmail.com"));
        students.add(new Student(2, "Thu Hằng", "hanggmail.com"));
        students.add(new Student(3, "Phương Loan", "loangmail.com"));

        students.forEach(std -> std.printInfo());
        students.forEach(std -> System.out.println(std));

        // Sắp xếp theo tên
        students.sort((std1, std2) -> std1.getName().compareTo(std2.getName()));

        students.sort(Comparator.comparing(Student::getName));
        students.forEach(System.out::println);

//        students.forEach(Student::printInfo);
//        students.forEach(System.out::println);
    }
}
