public class MathDemo {
    public static void main(String[] args) {
        System.out.println(Math.PI);

        System.out.println(Math.ceil(3.3));
        System.out.println(Math.floor(3.7));
        System.out.println(Math.round(3.4));
        System.out.println(Math.round(3.6));

        System.out.println(Math.max(10, 20));
        System.out.println(Math.min(11, 21));

        System.out.println((int) Math.pow(5, 2));
        System.out.println(Math.sqrt(25));

        System.out.println(Math.random());

        // Công thức tính random 1 số nguyên (0 -> n)
        int randomNumnber = (int) Math.floor(Math.random() * 100); // 0 -> 99
        System.out.println(randomNumnber);

        // Công thức tính random 1 số nguyên (n -> m)
        // 100 -> 999 (max - min + 1) + min
        int randomNumnber1 = (int) Math.floor(Math.random() * (999 - 100 + 1) + 100);
        System.out.println(randomNumnber1);
    }
}
