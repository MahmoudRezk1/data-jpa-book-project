package com.global.book.datajpabooksproject.repository;

import com.global.book.datajpabooksproject.base.BaseRepository;
import com.global.book.datajpabooksproject.entity.Author;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends BaseRepository<Author,Long> {
}
