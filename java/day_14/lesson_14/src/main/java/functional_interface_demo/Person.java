package functional_interface_demo;

@FunctionalInterface
interface Greeting {
    void sayHello(String name);
}

public class Person implements Greeting{
    @Override
    public void sayHello(String name) {
        System.out.println("Xin chào " + name);
    }

    public static void main(String[] args) {
        // Cách 1 : Sử dụng class cụ thể
        Greeting greeting = new Person();
        greeting.sayHello("Bùi Hiên");

        // Cách 2 : Sử dụng anonymous class
        Greeting greeting1 = new Greeting() {
            @Override
            public void sayHello(String name) {
                System.out.println("Hello " + name);
            }
        };
        greeting1.sayHello("Nguyễn Văn A");

        // Cách 3 : Sử dụng lambda expression
        Greeting greeting2 = name -> System.out.println("Konichiwa " + name);
        greeting2.sayHello("Trần Văn B");
    }
}
