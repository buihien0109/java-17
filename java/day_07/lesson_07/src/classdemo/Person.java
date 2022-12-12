package classdemo;

public class Person {
    // Thuộc tính (property)
    public String name;
    public String email;
    public int age;
    public String address;

    public Person() {}

    public Person(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Person(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public Person(String name, String email, int age, String address) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.address = address;
    }

    // Phương thức (method - hành động)
    public void play(String sportName) {
        System.out.println("Chơi " + sportName);
    }

    public void eat() {
        System.out.println("Ăn ...");
    }

    public void showInfo() {
        System.out.println(name + " - " + email + " - " + age + " - " + address);
    }

    public void usePhone(Phone phone) {
        System.out.println(name + " đang sử dụng điện thoại " + phone.name + " của hãng " + phone.brand);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
