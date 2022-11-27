package ir.sae.onlineshop.base;

import ir.sae.onlineshop.exceptions.BaseException;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

public class BaseServiceImpl<T extends BaseEntity, ID extends Serializable,
        R extends JpaRepository<T, ID>> implements BaseService<T, ID> {
    R repository;


    @Override
    public T save(T t) throws BaseException {
        return repository.save(t);
    }

    @Override
    public void deleteById(ID id) throws BaseException {

            repository.deleteById(id);


    }

    @Override
    public void deleteEntity(T t) throws BaseException {
        repository.delete(t);
    }

    @Override
    public T findById(ID id) throws BaseException {



            return repository.findById(id).get();
    }

    @Override
    public List<T> findAll() throws BaseException {
        return repository.findAll();
    }

    @Override
    public <S extends T> List<S> findAll(Example<S> example) {
        return null;
    }
}
