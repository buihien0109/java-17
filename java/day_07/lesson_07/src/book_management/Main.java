package book_management;

import book_management.controller.BookController;

public class Main {
    // Chi tiết các layer
    // 1. controller : Tiếp nhận request từ người dùng (Nhấn 1,2,3 để thực hiện chức năng - làm menu)
    // 2. service : Chứa business logic của ứng dụng
    // 3. repository : Chứa phương thức để lấy dữ liệu
    // 4. database : Chứa dữ liệu của ứng dụng (database)

    // model : Chứa các đối tượng (Student, Person, Film, ...)

    // actor -> gửi request (1,2,3) -> controller -> gửi thông tin request -> service -> repository

    public static void main(String[] args) {
        BookController bookController = new BookController();
        bookController.run();
    }
}
