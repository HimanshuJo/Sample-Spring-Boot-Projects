package com.capgemini.sbmongodb.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.capgemini.sbmongodb.docs.Book;

public interface BookRepository extends MongoRepository<Book, Long> {
    List<Book> findByCategory(String category);

    Book findByBookId(long bookId);
}
