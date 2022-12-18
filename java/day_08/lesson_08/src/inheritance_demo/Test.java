package inheritance_demo;

public class Test {
    public static void main(String[] args) {
        Dog dog = new Dog("Husky", "white", 4);
        dog.eat();
        dog.display();

        Dog dog1 = new Dog();
        dog1.setName("Pitbull");
        dog1.setColor("black");
        dog1.setLegs(4);
        dog1.eat();
        dog1.display();

        dog1.eyes = 2;
        dog1.ears = 2;
    }
}
