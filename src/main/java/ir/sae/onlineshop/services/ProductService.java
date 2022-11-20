package ir.sae.onlineshop.services;

import ir.sae.onlineshop.models.product.ProductEntity;

import java.util.List;

public interface ProductService {
    ProductEntity saveProduct(ProductEntity productEntity);

    ProductEntity getById(ProductEntity productEntity);

    List<ProductEntity> getAll();

}
