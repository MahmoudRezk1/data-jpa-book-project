package com.global.book.datajpabooksproject.base;

import com.global.book.datajpabooksproject.error.RecordNotFoundException;
import jakarta.persistence.MappedSuperclass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.List;
import java.util.Optional;

@MappedSuperclass
public class BaseService<T extends BaseEntity<ID>, ID extends Number> {
    @Autowired
    private BaseRepository<T, ID> baseRepository;
    @Autowired
    private MessageSource messageSource;

    public T findById(ID id) {
        Optional<T> entity = baseRepository.findById(id);
        if (entity.isPresent()){
        return entity.get();
        }else {
            String [] msgParam = {id.toString()};
           String message =  messageSource.getMessage("validation.constraints.RecordNotFoundException.message",msgParam, LocaleContextHolder.getLocale());
            throw new RecordNotFoundException(message);
        }
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
