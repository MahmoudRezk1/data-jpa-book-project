package com.global.book.datajpabooksproject.service;


import com.global.book.datajpabooksproject.base.BaseService;
import com.global.book.datajpabooksproject.entity.Book;
import com.global.book.datajpabooksproject.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService extends BaseService<Book,Long> {
    @Autowired
    private BookRepo bookRepo;


    public List<Book> insertAll(List<Book> books) {
        return bookRepo.saveAll(books);
    }

    public Book update(Book book) {
        Book current = bookRepo.findById(book.getId()).get();
        current.setName(book.getName());
        return bookRepo.save(current);
    }

    public int deleteByAuthorId (Long id){
        return bookRepo.deleteByAuthorId(id);
    }
}
