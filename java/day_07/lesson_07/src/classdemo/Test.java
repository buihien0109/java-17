package classdemo;

public class Test {
    public static void main(String[] args) {
        // Tạo ra đối tượng
        Person person = new Person();

        System.out.println(person.name); // null (default value của String)
        System.out.println(person.age);

        // gán các giá trị cho thuộc tính của đối tượng
        person.name = "Nguyễn Văn A";
        person.email = "a@gmail.com";
        person.age = 20;
        person.address = "Hà Nội";

        // in ra thông tin của đối tượng
        System.out.println(person.name + " - " + person.email + " - " + person.age + " - " + person.address);

        // gọi phương thức
        person.showInfo();
        person.eat();
        person.play("Bóng đá");

        System.out.println(person);

        // Khởi tạo đối tượng Phone
        Phone phone = new Phone();
        phone.name = "iPhone 13 pro";
        phone.brand = "Apple";

        person.usePhone(phone);

        // Khởi tạo đối tượng Calculator
        Calculator calculator = new Calculator();
        calculator.number1 = 10;
        calculator.number2 = 0;

        System.out.println(calculator.division());

        System.out.println("Code continue ...");

        // Khởi tạo đối tượng person với constructor
        Person person1 = new Person("Trần Văn B", "b@gmail.com");
        System.out.println(person1);

        Person person2 = new Person("Ngô Thị C", "c@gmail.com", 30, "Hải phòng");
        System.out.println(person2);
    }
}
