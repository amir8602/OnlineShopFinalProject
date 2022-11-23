package ir.sae.onlineshop.services;

import ir.sae.onlineshop.models.product.ProductEntity;
import org.springframework.data.domain.Example;

import java.util.ArrayList;
import java.util.List;

public interface ProductService {

    ProductEntity saveProduct(ProductEntity productEntity);

    ProductEntity updateProduct(ProductEntity productEntity);

    List<ProductEntity> searchByExample(Example<ProductEntity> entityExample);
    void deleteProduct(Long id);

    ProductEntity getById( ProductEntity productEntity);

    List<ProductEntity> getAll();

}
