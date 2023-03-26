package com.global.book.datajpabooksproject.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity<ID>, ID extends Number> extends JpaRepository<T, ID> {
    @Transactional
    @Modifying
    @Query(value = "update #{#entityName} t set t.statusCode =:statusCode where t.id=:id ")
    void updateEntity(@Param("id") Long id, @Param("statusCode") String statusCode);
}
