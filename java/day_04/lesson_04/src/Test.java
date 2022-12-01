public class Test {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

//        a = b; // a = 20; b = 20;
//        b = a;

        int temp = a; // temp = 10
        a = b; // a = 20
        b = temp; // b = 10
    }
}
