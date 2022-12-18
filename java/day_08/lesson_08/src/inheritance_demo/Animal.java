package inheritance_demo;

public class Animal {
    // Thuộc tính
    private String name;

    // Constructor của lớp cha
    public Animal() {
    }

    public Animal(String name) {
        this.name = name;
    }

    // Phương thức của lớp cha
    public void eat() {
        System.out.println("Animal eat...");
    }

    // Các method getter, setter tương ứng với các thuộc tính
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
