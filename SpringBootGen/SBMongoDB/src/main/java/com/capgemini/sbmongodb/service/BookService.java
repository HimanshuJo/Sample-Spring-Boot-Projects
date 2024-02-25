package com.capgemini.sbmongodb.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.sbmongodb.docs.Book;
import com.capgemini.sbmongodb.repository.BookRepository;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Book> getBookByCategory(String category) {
        List<Book> book = bookRepository.findByCategory(category);
        return book;
    }

    public Book getBookByBookId(long bookId) {
        Book book = bookRepository.findByBookId(bookId);
        return book;
    }

    public Book addBook(long id, String isbnNumber, String bookName, String category) {
        Book book = new Book();
        book.setCategory(category);
        book.setBookId(id);
        book.setBookName(bookName);
        book.setIsbnNumber(isbnNumber);
        return bookRepository.save(book);
    }

    public int deleteBook(long bookId) {
        Book book = bookRepository.findByBookId(bookId);
        if (book != null) {
            bookRepository.delete(book);
            return 1;
        }
        return -1;
    }
}
