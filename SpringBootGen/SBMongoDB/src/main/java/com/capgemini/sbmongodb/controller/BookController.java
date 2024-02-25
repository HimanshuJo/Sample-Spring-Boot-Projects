package com.capgemini.sbmongodb.controller;

import java.util.List;
import com.capgemini.sbmongodb.docs.Book;
import com.capgemini.sbmongodb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping("/getAllBooks")
    @ResponseBody
    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }

    @RequestMapping("/getBookByCategory")
    @ResponseBody
    public List<Book> getBook(@RequestParam("category") String category) {
        return bookService.getBookByCategory(category);
    }

    @RequestMapping("/getBookById")
    @ResponseBody
    public Book getBookById(@RequestParam("bookId") long bookId) {
        return bookService.getBookByBookId(bookId);
    }

    @RequestMapping("/addBook")
    @ResponseBody
    public String addBook(@RequestParam("bookId") long bookId,
            @RequestParam("isbnNumber") String isbnNumber,
            @RequestParam("bookName") String bookName,
            @RequestParam("category") String category) {
        if (bookService.addBook(bookId, isbnNumber, bookName, category) != null) {
            return "Book Added Successfully";
        } else {
            return "Error!";
        }
    }

    @RequestMapping("/deleteBook")
    @ResponseBody
    public String deleteBook(@RequestParam("bookId") int bookId) {
        if (bookService.deleteBook(bookId) == 1) {
            return "Book got Deleted Successfully";
        } else {
            return "Something went wrong!";
        }
    }
}
