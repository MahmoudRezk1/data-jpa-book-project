package com.global.book.datajpabooksproject.repository;

import com.global.book.datajpabooksproject.base.BaseRepository;
import com.global.book.datajpabooksproject.entity.Book;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepo extends BaseRepository<Book,Long> {
    @Override
    @EntityGraph(value = "loadAuthor")
    Optional<Book> findById (Long id);

    @Override
    @EntityGraph(attributePaths = {"author"})
    List<Book> findAll();
    @Transactional
    @Modifying
    @Query(value = "delete from Book where author.id = :id ")
    int deleteByAuthorId (Long id);
}
