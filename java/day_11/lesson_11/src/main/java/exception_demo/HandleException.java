package exception_demo;

public class HandleException {
    public static void main(String[] args) {
        try {
            methodOne();
            methodTwo();
        } catch (ArithmeticException | NullPointerException e) {
            System.out.println("Lỗi rồi xử lý đi");
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("finally");
        }

//        catch (NullPointerException e) {
//            System.out.println("Xử lý lỗi NullPointerException");
//        }

        System.out.println("Code continue ...");
    }

    public static void methodOne() {
        int number = 9;
        int zero = 1;
        System.out.println(number / zero);
    }

    public static void methodTwo() {
        String str = "abc";
        System.out.println(str.length());
    }
}
