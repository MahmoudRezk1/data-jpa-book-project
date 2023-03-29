package com.global.book.datajpabooksproject.repository;

import com.global.book.datajpabooksproject.base.BaseRepository;
import com.global.book.datajpabooksproject.entity.Author;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepo extends BaseRepository<Author,Long> , JpaSpecificationExecutor<Author> {
    Optional<Author> findByEmail(String email);
}
