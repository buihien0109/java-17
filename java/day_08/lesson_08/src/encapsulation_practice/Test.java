package encapsulation_practice;

import inheritance_demo.Dog;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Student std = new Student("1", -1, 15, "nhb");
        std.showInfo();
        std.calculateScholarship();

        Student std1 = new Student("12345678", 9, 25, "A123");
        std1.showInfo();
        std1.calculateScholarship();

        Dog dog = new Dog("Husky", "white", 4);
        dog.tails =1;
        // dog.eyes không thể truy cập bên người package
        // dog.ears không thể truy cập bên người package

        Scanner sc = new Scanner(System.in);
    }
}
