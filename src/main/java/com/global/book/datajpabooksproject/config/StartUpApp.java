package com.global.book.datajpabooksproject.config;

import com.global.book.datajpabooksproject.entity.Author;
import com.global.book.datajpabooksproject.entity.Book;
import com.global.book.datajpabooksproject.service.AuthorService;
import com.global.book.datajpabooksproject.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class StartUpApp implements CommandLineRunner {
    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookService bookService;
    @Override
    public void run(String... args) throws Exception {

//       adding demo data for Author Table
        if(authorService.findAll().isEmpty()) {
            Author author1 = new Author();
            author1.setName("Ali");
            Author author2 = new Author();
            author2.setName("Mahmoud");
            Author author3 = new Author();
            author3.setName("Ahmed");

            authorService.insertAll(Arrays.asList(author1, author2, author3));
        }

//        adding demo data for Book Table
        if(bookService.findAll().isEmpty()) {
            Book book1 = new Book();
            book1.setName("Data Jpa");
            book1.setPrice(100.0);
            book1.setAuthor(authorService.getById(1L));

            Book book2 = new Book();
            book2.setName("JDBC Data");
            book2.setPrice(200.0);
            book2.setAuthor(authorService.getById(2L));

            Book book3 = new Book();
            book3.setName("Boot");
            book3.setPrice(300.0);
            book3.setAuthor(authorService.getById(3L));

            bookService.insertAll(Arrays.asList(book1, book2, book3));
        }
    }
}
