package ir.sae.onlineshop.base;

import ir.sae.onlineshop.exceptions.BaseException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

//@Transactional(readOnly = true)
@RequiredArgsConstructor
@AllArgsConstructor
public class BaseServiceImpl<T extends BaseEntity, ID extends Serializable,
        R extends JpaRepository<T, ID>> implements BaseService<T, ID> {


    @Autowired
    private R repository;

    private final static Logger LOGGER = LoggerFactory.getLogger(BaseServiceImpl.class);

    @Transactional
    @Override
    public T saveOrUpdate(T t) throws BaseException {
        return repository.save(t);
    }


    @Override
    @Transactional
    public void deleteById(ID id) throws BaseException {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            LOGGER.error("entity not found", e);
            throw new BaseException("Entity.Not.Found", e.getCause(), "EmptyResultDataAccessException");
        }
    }


    @Override
    @Transactional
    public void deleteEntity(T t) throws BaseException {
        try {
            repository.delete(t);
        } catch (EmptyResultDataAccessException e) {
            LOGGER.error("entity not found", e);
            throw new BaseException("Entity.Not.Found", e.getCause(), "EmptyResultDataAccessException");
        }
    }


    @Override
    @Transactional
    public <S extends T> List<S> findAll(S input) throws BaseException {
        return repository.findAll(Example.of(input));
    }
}
