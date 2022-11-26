public class Operator {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        int c = a++; // c = 10, a = 11
//        System.out.println(c);
//        System.out.println(a);
        int d = ++a; // a = 12, d = 12
//        System.out.println(a);
//        System.out.println(d);

        int e = a++ + ++b; // b = 21, e = a + b = 12 + 21 = 33, a = 13
//        System.out.println(b);
//        System.out.println(e);
//        System.out.println(a);

        int f = ++a + ++b; // a = 14, b = 22, f = 36
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(f);
    }
}
