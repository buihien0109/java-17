public class ForPractice {
    public static void main(String[] args) {
        System.out.println(repeatString("hien"));

        System.out.println(repeatString01("hello", 50));
    }

    public static String repeatString(String str) {
        String rs = "";
        for (int i = 0; i < 10; i++) {
            rs += str;
        }
        return rs;
        // 1. rs = "" + "a" => "a"
        // 2. rs = "a" + "a" => "aa"
        // 3. rs = "aa" + "a" => "aaa"
     }

    public static String repeatString01(String str, int count) {
        String rs = "";
        for (int i = 0; i < count; i++) {
            rs += str;
        }
        return rs;
    }
}
