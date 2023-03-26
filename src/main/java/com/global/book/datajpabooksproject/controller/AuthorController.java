package com.global.book.datajpabooksproject.controller;

import com.global.book.datajpabooksproject.entity.Author;
import com.global.book.datajpabooksproject.service.AuthorService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/author")
@Validated
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping(path = "/findById")
    public ResponseEntity<?> findById(@RequestParam @Min(1) @Max(1000) Long id) {
        return ResponseEntity.ok(authorService.findById(id));
    }

    @GetMapping(path = "/findAll")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(authorService.findAll());
    }

    @PostMapping(path = "/insert")
    public ResponseEntity<?> insert(@RequestBody @Valid Author author) {
        return ResponseEntity.ok(authorService.insert(author));
    }

    @PutMapping(path = "/update")
    public ResponseEntity<?> update(@RequestBody @Valid Author author) {

        return ResponseEntity.ok(authorService.update(author));
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<?> deleteById(@RequestParam Long id) {
        authorService.deleteById(id);
        return ResponseEntity.ok(null);
    }
}

