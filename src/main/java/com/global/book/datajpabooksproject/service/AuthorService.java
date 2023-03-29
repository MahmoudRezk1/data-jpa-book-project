package com.global.book.datajpabooksproject.service;

import com.global.book.datajpabooksproject.base.BaseService;
import com.global.book.datajpabooksproject.entity.Author;
import com.global.book.datajpabooksproject.entity.AuthorSearch;
import com.global.book.datajpabooksproject.error.DuplicateRecordException;
import com.global.book.datajpabooksproject.repository.AuthorRepo;
import com.global.book.datajpabooksproject.repository.AuthorSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService extends BaseService<Author,Long> {
    @Autowired
    private AuthorRepo authorRepo;
    @Override
    public Author insert(Author t) {
        if (findByEmail(t.getEmail()).isPresent()){
            throw new DuplicateRecordException("This email already found with another auther");
        }else
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
