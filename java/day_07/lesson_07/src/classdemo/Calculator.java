package classdemo;

public class Calculator {
    public int number1;
    public int number2;

    public double division() {
        double result = 0;
        try {
            result = (double) (number1 / number2);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
