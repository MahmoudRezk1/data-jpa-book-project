package com.global.book.datajpabooksproject.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.global.book.datajpabooksproject.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.Formula;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author extends BaseEntity<Long> {
    @NotNull(message = "should enter name")
    @NotEmpty
    @NotBlank
    private String name;
    @Pattern(regexp = "^([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})$")
    private String ipAddress;
    @Email
    private String email;


    @Formula("(select count(*) from books book where book.author_id=id)")
    private Long countBook;
//    @NotEmpty
    @JsonManagedReference
    @OneToMany(mappedBy = "author")
    private List<Book> books = new ArrayList<>();

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void deleteBook(Book book) {
        books.remove(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCountBook() {
        return countBook;
    }

    public void setCountBook(Long countBook) {
        this.countBook = countBook;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
