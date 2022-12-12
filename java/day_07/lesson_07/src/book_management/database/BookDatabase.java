package book_management.database;

import book_management.model.Book;

// Fake database books
public class BookDatabase {
    public static Book[] books = {
            new Book(1, "Người khốn khổ"),
            new Book(2, "Dế mèn phiêu lưu ký"),
            new Book(3, "Trò chuyện buổi sáng"),
            new Book(4, "Đắc nhân tâm"),
    };
}
