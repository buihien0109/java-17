package student_management;

import student_management.model.Student;
import student_management.service.StudentService;

public class Test {
    // CRUD : Create - Read - Update - Delete
    public static void main(String[] args) {
        StudentService studentService = new StudentService();

//        Student student = studentService.createStudent();
//        studentService.printInfo(student);

        // Nhập nhều đối tượng student
        Student[] students = new Student[3];
        for (int i = 0; i < students.length; i++) {
            students[i] = studentService.createStudent();
        }

        for (Student value : students) {
            studentService.printInfo(value);
        }
    }
}
