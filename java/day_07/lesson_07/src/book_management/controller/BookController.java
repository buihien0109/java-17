package book_management.controller;

import book_management.service.BookService;

import java.util.Scanner;

// Lấy thông tin người dùng tương tác với hệ thống --> gọi các hàm sử lý tương ứng ở trong service
public class BookController {
    public BookService bookService = new BookService();

    public void run() {
        Scanner sc = new Scanner(System.in);

        int option = 0;
        boolean isQuit = false;

        while (!isQuit) {
            showMenu();

            System.out.print("Nhập lựa chọn : ");
            option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1: {
                    System.out.print("Nhập tiêu đề book cần tìm : ");
                    String title = sc.nextLine();
                    bookService.findByTitle(title);
                    break;
                }
                case 2: {
                    isQuit = true;
                    break;
                }
                default: {
                    System.out.println("Lựa chọn không hợp lệ");
                    break;
                }
            }
        }
    }

    public static void showMenu() {
        System.out.println("\n********* MENU *********");
        System.out.println("1 - Tìm kiếm book theo tên");
        System.out.println("2 - Thoát\n");
    }
}
