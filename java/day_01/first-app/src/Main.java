public class Main {
    // Phạm vi global : Khai báo bên ngoài method
    public static String globalVar = "Global variable";

    // Phạm vi method : Khai báo bên trong method
    // Phạm vi block : Khai báo bên trong  {}
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // Khai báo biến
        String firstName;
        String lastName;
        String email = "hien@techmaster.vn";

        // Gán giá trị cho biến
        firstName = "Bùi";
        lastName = "Hiên";
        String fullName = firstName + " " + lastName;
        int age = 25;
        String address = "Thái Bình";

        System.out.println("firstName = " + firstName);
        System.out.println("lastName = " + lastName);
        System.out.println("fullName = " + fullName);
        System.out.println("Xin chào, tôi tên là " + fullName + ". Năm nay tôi " + age + " tuổi. Quê tôi ở " + address);

        int string = 1;
        int sTring;
        String first_name; // snake_case
        System.out.println(string);

        // Khai báo các kiểu dữ liệu
        long salary = 1_000_000_000L;
        double height = 1.7;
        float weight = 60.5f;

        System.out.println(salary);

        // Kieu boolean
        boolean isExist = true;
        boolean isMarried = false;

        // Kiểu char
        char characterA = 'A';
        char characterB = 66; // Tra bảng mã ASCII

        System.out.println(characterA);
        System.out.println(characterB);

        // Ép kiểu
        // Ép kiểu ngầm định (nho -> lon)
        int number = 10;
        long numberOne = number;

        // Ép kiểu tường minh
        short numberTwo = (short) number;

        // Gọi biến global
        System.out.println(globalVar);

        // Phạm vi block
        {
            String blockVar = "block variable";
            System.out.println(blockVar);
        }
        // System.out.println(blockVar); // Ngoài phạm vi sử dụng --> error
    }
}


// Java Code -> ByteCode -> Mã máy -> Thực thi