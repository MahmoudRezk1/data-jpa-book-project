package com.global.book.datajpabooksproject.service;

import com.global.book.datajpabooksproject.base.BaseService;
import com.global.book.datajpabooksproject.entity.Author;
import com.global.book.datajpabooksproject.entity.AuthorSearch;
import com.global.book.datajpabooksproject.error.DuplicateRecordException;
import com.global.book.datajpabooksproject.repository.AuthorRepo;
import com.global.book.datajpabooksproject.repository.AuthorSpec;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService extends BaseService<Author,Long> {
    @Autowired
    private AuthorRepo authorRepo;
    Logger logger = LoggerFactory.getLogger(AuthorService.class);
    @Override
    public Author insert(Author t) {
        if (!t.getEmail().isEmpty() && t.getEmail()!=null) {
            Optional<Author> author = findByEmail(t.getEmail());
            logger.info("Author name is {} and email is {}", t.getName(), t.getEmail());
            if (author.isPresent()) {
                logger.error("This email already found with another author");
                throw new DuplicateRecordException("This email already found with another author");
            }
        }
            return authorRepo.save(t);
    }
    @Override
    public Author update(Author author){
        Author author1 = findById(author.getId());
        author1.setName(author.getName());
        return super.update(author1);
    }
    public List<Author> getAuthorBySpec(AuthorSearch authorSearch){
        AuthorSpec authorSpec = new AuthorSpec(authorSearch);
        return authorRepo.findAll(authorSpec);
    }
    public Optional<Author> findByEmail(String email){
        return authorRepo.findByEmail(email);
    }
}
