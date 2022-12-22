package book_management.frontend.ui;

import book_management.backend.controller.BookController;
import book_management.backend.exception.NotFoundException;
import book_management.backend.model.Book;

import java.util.List;
import java.util.Scanner;

public class BookUI {
    private final BookController bookController = new BookController();

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
                    List<Book> books = bookController.getBooks();
                    if(books.isEmpty()) {
                        System.out.println("Không có quyển sách nào trong danh sách");
                    } else {
                        System.out.println("Danh sách book : ");
                        for (Book b : books) {
                            System.out.println(b);
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.print("Nhập tên sách : ");
                    String name = sc.nextLine();

                    List<Book> books = bookController.getBooksByName(name);
                    if(books.isEmpty()) {
                        System.out.println("Không có quyển sách nào có tên là : " + name);
                    } else {
                        System.out.println("Danh sách book có tên " + name + " là : ");
                        for (Book b : books) {
                            System.out.println(b);
                        }
                    }
                    break;
                }
                case 3 : {
                    System.out.print("Nhập id cần xóa : ");
                    int id = Integer.parseInt(sc.nextLine());

                    try {
                        bookController.deleteBook(id);
                    } catch (NotFoundException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                }
                case 4: {
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
        System.out.println("1 - Xem danh sách books");
        System.out.println("2 - Tìm sách theo tên");
        System.out.println("3 - Xóa sách theo id");
        System.out.println("4 - Thoát\n");
    }
}
