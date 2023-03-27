package com.global.book.datajpabooksproject.repository;

import com.global.book.datajpabooksproject.entity.Author;
import com.global.book.datajpabooksproject.entity.AuthorSearch;
import com.global.book.datajpabooksproject.entity.Book;
import jakarta.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class AuthorSpec implements Specification<Author> {
    private AuthorSearch authorSearch;

    public AuthorSpec(AuthorSearch authorSearch) {
        this.authorSearch = authorSearch;
    }

    @Override
    public Predicate toPredicate(Root<Author> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        Join<Author, Book> joinBook = root.join("books", JoinType.LEFT);
        List<Predicate> predicates = new ArrayList<>();
//      author name
        if (authorSearch.getAuthorName() != null && !authorSearch.getAuthorName().isEmpty()) {
            predicates.add(cb.like(root.get("name"), authorSearch.getAuthorName()));
        }
//        email
        if (authorSearch.getEmail() != null && !authorSearch.getEmail().isEmpty()) {
            predicates.add(cb.like(root.get("email"), authorSearch.getEmail()));
        }
//        ip Address
        if (authorSearch.getIpAddress() != null && !authorSearch.getIpAddress().isEmpty()) {
            predicates.add(cb.like(root.get("ipAddress"), "%" + authorSearch.getIpAddress() + "%"));
        }
//        join with books attribute
//        bookName
        if (authorSearch.getBookName() != null && !authorSearch.getBookName().isEmpty()) {
            predicates.add(cb.like(joinBook.get("books"), authorSearch.getBookName()));
        }
//        bookPrice
        if (authorSearch.getPrice() != null) {
            predicates.add(cb.greaterThanOrEqualTo(joinBook.get("price"), authorSearch.getPrice()));
        }
        return cb.and(predicates.toArray(new Predicate[0]));

    }


}
