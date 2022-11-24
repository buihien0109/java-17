public class MethodDemo {
    public static void main(String[] args) {
        // Công việc A : Tốn mất 20 dòng code
        // Thực hiện cv A 10 lần : Tốn 200 dòng code
        // Có method : tốn thêm 10 dòng để gọi

        int data = sumTwoNumber(3, 4);
        System.out.println(data);

        System.out.println(sumTwoNumber(10, 20));
        System.out.println(30);

        sayHello();

        // Cách 2 : Định nghĩa đối tượng -> gọi method của đối tượng (thể hiện, instance) đấy
        // Class : Khuôn bánh (chỉ có 1)
        // Object : Bánh sinh ra từ khuôn (có nhiều)
        MethodDemo methodDemo = new MethodDemo();
        methodDemo.sayHelloWithName("Bùi Hiên");
        methodDemo.sayHelloWithName("Nguyễn Văn A");
        methodDemo.sayHelloWithName("Trần Văn B");
    }

    // Tính tổng 2 số : trả về kết quả là tổng của 2 số a, b
    // Tham số : parameter (giá trị ảo, chưa biết trước khi định nghĩa method)
    // Đối số : argument (giá trị thật khi gọi method)
    public static int sumTwoNumber(int a, int b) {
        int result = a + b;
        System.out.println("abc");
        return result;

        // Những câu lệnh đằng sau từ khóa return sẽ không được thực thi
        // System.out.println("abc");
    }

    public static void sayHello() {
        System.out.println("Xin chào các bạn");
    }

    // Ví dụ method có 1 tham số
    public void sayHelloWithName(String name) {
        System.out.println("Xin chào " + name);
    }
}
