package ir.sae.onlineshop.services;

import ir.sae.onlineshop.base.BaseService;
import ir.sae.onlineshop.entities.ProductEntity;
import org.springframework.data.domain.Example;

import java.util.List;

public interface ProductService extends BaseService<ProductEntity, Long> {

    List<ProductEntity> search(Example<ProductEntity> example);




//    ProductEntity saveProduct(ProductEntity productEntity);
//
//    ProductEntity getById(ProductEntity productEntity);
//
//    List<ProductEntity> getAll();
//
//    ProductEntity update(ProductEntity productEntity);
//
//    void delete(ProductEntity productEntity);


}
