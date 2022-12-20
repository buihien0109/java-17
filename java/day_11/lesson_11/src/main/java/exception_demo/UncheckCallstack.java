package exception_demo;

public class UncheckCallstack {
    public static void main(String[] args) {
        methodThree();
    }

    public static void methodOne() {
        System.out.println("one");
        throw new ArithmeticException("Lỗi toán học");
    }

    public static void methodTwo() {
        System.out.println("two");
        methodOne();
    }

    public static void methodThree() {
        System.out.println("three");
        try {
            methodTwo();
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
