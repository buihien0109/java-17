package book_management.repository;

import book_management.database.BookDatabase;
import book_management.model.Book;

// Chứa các method để lấy dữ liệu trong database
public class BookRepository {
    // Lấy tất cả books trong database
    public Book[] findAll() {
        return BookDatabase.books;
    }
}
