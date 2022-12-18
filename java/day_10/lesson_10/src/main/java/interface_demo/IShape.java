package interface_demo;

public interface IShape {
    String message = "shape"; // public, static, final

    double getArea();
    double getPerimeter();

    default void sayHello() {
        System.out.println("Hello shape");
    }

    static void hi() {
        System.out.println("Hi");
    }
}
