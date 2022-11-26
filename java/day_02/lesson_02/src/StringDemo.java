public class StringDemo {
    public static void main(String[] args) {
        // Khai báo kiểu literal
        String name = "Bùi Hiên";
        String name1 = "Bùi Hiên";

        // Khai báo kiểu Object (new)
        String email = new String("hien@techmaster.vn");
        String email1 = new String("hien@techmaster.vn");

        System.out.println("name : " + name);
        System.out.println("email : " + email);

        // So sánh chuỗi
        // == so sánh về mặt địa chỉ ô nhớ ( thường được áp dụng với primative type)
        System.out.println(name == name1); // true
        System.out.println(email == email1); // false

        // Phương thức String
        String text = "Xin chào các bạn";
        String text1 = "Xin chào các bạn";
        String text2 = "Xin cHào Các bạN";

        System.out.println("In hoa : " + text.toUpperCase());
        System.out.println("In thường : " + text.toLowerCase());
        System.out.println("Độ dài : " + text.length());
        System.out.println("Cắt chuỗi : " + text.substring(0, 8));
        System.out.println("Vị trí 10 là ký tự : " + text.charAt(9));
        System.out.println("So sánh : " + text.equals(text1));
        System.out.println("So sánh không phân biệt hoa thường : " + text.equalsIgnoreCase(text2));
    }
}
