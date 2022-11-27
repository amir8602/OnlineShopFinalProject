package ir.sae.onlineshop.services.impl;

import ir.sae.onlineshop.base.BaseServiceImpl;
import ir.sae.onlineshop.entities.ProductEntity;
import ir.sae.onlineshop.repositories.ProductRepository;
import ir.sae.onlineshop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl  extends BaseServiceImpl<ProductEntity,
        Long, ProductRepository> implements ProductService {


    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductEntity> search(Example<ProductEntity> example) {
        return productRepository.findAll(example);
    }
//    @Override
//    public ProductEntity saveProduct(ProductEntity productEntity) {
//        return productRepository.save(productEntity);
//    }
//
//    @Override
//    public ProductEntity getById(ProductEntity productEntity) {
//        return productRepository.getById(productEntity.getId());
//    }
//
//    @Override
//    public List<ProductEntity> getAll() {
//        return productRepository.findAll();
//    }
//
//    @Override
//    public ProductEntity update(ProductEntity productEntity) {
//        return productRepository.save(productEntity);
//    }
//
//    @Override
//    public void delete(ProductEntity productEntity) {
//        productRepository.deleteById(productEntity.getId());
//    }


}
