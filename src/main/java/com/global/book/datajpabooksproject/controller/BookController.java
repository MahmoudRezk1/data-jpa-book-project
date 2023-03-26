package com.global.book.datajpabooksproject.controller;

import com.global.book.datajpabooksproject.dto.BookDto;
import com.global.book.datajpabooksproject.entity.Book;
import com.global.book.datajpabooksproject.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping(path = "/findById")
    public ResponseEntity<?> findById(Long id) {
        Book book = bookService.findById(id);
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setName(book.getName());
        bookDto.setPrice(book.getPrice());
        bookDto.setAuthor(book.getAuthor());
        return ResponseEntity.ok(bookDto);
    }

    @GetMapping(path = "/findAll")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(bookService.findAll());
    }

    @PostMapping(path = "/insert")
    public ResponseEntity<?> insert(@RequestBody @Valid Book book) {
        return ResponseEntity.ok(bookService.insert(book));
    }

    @PutMapping(path = "/update")
    public ResponseEntity<?> update(@RequestBody @Valid Book book) {

        return ResponseEntity.ok(bookService.update(book));
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<?> deleteById(@RequestParam Long id) {
        bookService.deleteById(id);
        return ResponseEntity.ok(null);
    }
    @DeleteMapping(path = "/deleteByAuthorId")
    public ResponseEntity<?> deleteByAuthorId (@RequestParam Long id){
        return ResponseEntity.ok(bookService.deleteByAuthorId(id));
    }

}
