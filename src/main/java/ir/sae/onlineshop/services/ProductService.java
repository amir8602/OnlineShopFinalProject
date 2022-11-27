package ir.sae.onlineshop.services;

import ir.sae.onlineshop.entities.ProductEntity;
import ir.sae.onlineshop.exceptions.BaseException;
import org.springframework.data.domain.Example;

import java.util.List;

public interface ProductService {
    ProductEntity saveProduct(ProductEntity productEntity)throws BaseException;

    ProductEntity getById(ProductEntity productEntity)throws BaseException;

    List<ProductEntity> getAll()throws BaseException;

    ProductEntity update(ProductEntity productEntity)throws BaseException;

    void delete(ProductEntity productEntity)throws BaseException;

    List<ProductEntity> searchByExample(Example<ProductEntity> of)throws BaseException;
}
