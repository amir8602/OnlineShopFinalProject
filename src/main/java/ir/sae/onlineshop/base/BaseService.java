package ir.sae.onlineshop.base;

import ir.sae.onlineshop.exceptions.BaseException;

import java.io.Serializable;
import java.util.List;

public interface BaseService<T extends BaseEntity, ID extends Serializable> {
    T saveOrUpdate(T t) throws BaseException;

    void deleteById(ID id) throws BaseException;

    void deleteEntity(T t) throws BaseException;

    <S extends T> List<S> findAll(S input) throws BaseException;

}