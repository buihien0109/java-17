package book_management.backend.service;

import book_management.backend.model.Book;
import book_management.backend.repository.BookRepository;
import book_management.backend.request.UpdateBookRequest;

import java.util.ArrayList;
import java.util.List;

public class BookService {
    private final BookRepository bookRepository = new BookRepository();

    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    public List<Book> getBooksByName(String name) {
        List<Book> books = bookRepository.findAll();
        List<Book> rs = new ArrayList<>();

        for (Book book: books) {
            if(book.getTitle().toLowerCase().contains(name.toLowerCase())) {
                rs.add(book);
            }
        }

        return rs;
    }

    public void deleteBook(int id) {
        // Không có sách -> báo lỗi
        Book book = bookRepository.findById(id);

        // Có sách -> xóa
        bookRepository.delete(book);
    }

    public Book updateBook(int id, UpdateBookRequest request) {
        return bookRepository.update(id, request);
    }
}
