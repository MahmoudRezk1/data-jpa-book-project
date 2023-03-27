package com.global.book.datajpabooksproject.base;

import jakarta.persistence.MappedSuperclass;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@MappedSuperclass
public class BaseService<T extends BaseEntity<ID>, ID extends Number> {
    @Autowired
    private BaseRepository<T, ID> baseRepository;

    public T findById(ID id) {
        return baseRepository.findById(id).get();
    }

    public T getById(ID id) {
        return baseRepository.getById(id);
    }

    public List<T> findAll() {
        return baseRepository.findAll();
    }

    public T insert(T t) {
        return baseRepository.save(t);
    }

    public List<T> insertAll(List<T> Ts) {

        return baseRepository.saveAll(Ts);
    }

    public T update(T t) {
        return baseRepository.save(t);
    }

    public void deleteById(ID id) {
        baseRepository.deleteById(id);
    }
}
