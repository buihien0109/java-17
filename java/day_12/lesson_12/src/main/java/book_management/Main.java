package book_management;

import book_management.backend.database.BookDB;
import book_management.backend.model.Book;

public class Main {
    public static void main(String[] args) {
        for (Book b: BookDB.books) {
            System.out.println(b);
        }
    }
}
