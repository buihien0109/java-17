package wrapper_class_demo;

public class Main {
    public static void main(String[] args) {
        // Định nghĩa các biến thuộc kiểu dữ liệu nguyên thủy
//        int a = 5;
//        double b = 5.65;

        // Chuyển đổi thành wrapper objects tương ứng
//        Integer aObj = Integer.valueOf(a);
//        Double bObj = Double.valueOf(b);
//
//        if(aObj instanceof Integer) {
//            System.out.println("Một object thuộc Integer đã được tạo.");
//        }
//
//        if(bObj instanceof Double) {
//            System.out.println("Một object thuộc Double đã được tạo.");
//        }

        // Tạo object thuộc wrapper class
        Integer aObj = Integer.valueOf(23);
        Double bObj = Double.valueOf(5.55);

        // Chuyển đổi thành kiểu dữ liệu nguyên thủy tương ứng
        int a = aObj.intValue();
        double b = bObj.doubleValue();

        System.out.println("Giá trị a = " + a);
        System.out.println("Giá trị b = " + b);

        // 1 2 4 5
    }
}
