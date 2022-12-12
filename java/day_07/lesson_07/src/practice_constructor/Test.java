package practice_constructor;

public class Test {
    public static void main(String[] args) {
        Employee employee = new Employee("Hien", 20, "HN", 210);
        System.out.println(employee.getSalary());

        Employee employee1 = new Employee("Hien", 20, "HN", 90);
        System.out.println(employee1.getSalary());
    }
}
