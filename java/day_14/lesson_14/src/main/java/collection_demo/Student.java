package collection_demo;

import lombok.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student implements Comparable<Student>{
    private String name;
    private double point;

    @Override
    public int compareTo(Student o) {
        return this.getName().compareTo(o.getName());
    }

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("John", 8.5));
        students.add(new Student("Anna", 9));
        students.add(new Student("Victor", 7));
        students.add(new Student("Chris", 6.5));

        System.out.println("Danh sách học sinh: ");
        show(students);

        Collections.sort(students);
        System.out.println("Danh sách sau khi sắp xếp: ");
        show(students);

        //Sắp xếp theo tên
//        Collections.sort(students, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                //Cài đặt chỉ tiêu để so sánh trong đây
//                return o1.getName().compareTo(o2.getName());
//            }
//        });
//        Collections.sort(students, (o1, o2) -> {
//            return o1.getName().compareTo(o2.getName());
//        });

        Collections.sort(students, Comparator.comparing(Student::getName));

        System.out.println("Danh sách sau khi sắp xếp tăng dần: ");
        show(students);

        //Sắp xếp theo điểm
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                //Cài đặt chỉ tiêu để so sánh trong đây
                return o2.getPoint() - o1.getPoint() >= 0 ? 1 : -1;
            }
        });

        System.out.println("Danh sách sau khi sắp xếp điểm giảm dần: ");
        show(students);
    }

    public static void show(ArrayList<Student> list){
        for (Student student: list) {
            System.out.println(student);
        }
    }
}
