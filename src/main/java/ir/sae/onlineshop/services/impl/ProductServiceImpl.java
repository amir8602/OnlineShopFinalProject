package ir.sae.onlineshop.services.impl;

import ir.sae.onlineshop.models.product.ProductEntity;
import ir.sae.onlineshop.models.product.dao.ProductDao;
import ir.sae.onlineshop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;
    @Override
    public ProductEntity saveProduct(ProductEntity productEntity) {
        return productDao.save(productEntity);
    }

    @Override
    public ProductEntity getById(ProductEntity productEntity) {
        return productDao.getById(productEntity.getId());
    }

    @Override
    public List<ProductEntity> getAll() {
        return productDao.findAll();
    }

    @Override
    public ProductEntity update(ProductEntity productEntity) {
        return productDao.save(productEntity);
    }

    @Override
    public void delete(ProductEntity productEntity) {
        productDao.deleteById(productEntity.getId());
    }

    @Override
    public List<ProductEntity> searchByExample(Example<ProductEntity> of) {
        return productDao.findAll(of);
    }
}
