package thisdemo;

public class Test {
    public static void main(String[] args) {
        Student student = new Student("Trần Thị C", 30, Gender.FEMALE);
        student.methodTwo();


        System.out.println(student.setAge());
    }
}
