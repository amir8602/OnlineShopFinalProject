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
    ProductDao productDao;

    @Override
    public ProductEntity saveProduct(ProductEntity productEntity) {
        return productDao.save(productEntity);
    }

    @Override
    public ProductEntity updateProduct(ProductEntity productEntity) {
        return productDao.save(productEntity);
    }

    @Override
    public List<ProductEntity> searchByExample(Example<ProductEntity> entityExample) {
        return productDao.findAll(entityExample);
    }

    @Override
    public void deleteProduct(Long id) {
        productDao.deleteById(id);

    }

    @Override
    public ProductEntity getById(ProductEntity productEntity) {
       return productDao.findById(productEntity.getId()).get();
    }

    @Override
    public List<ProductEntity> getAll() {
      return productDao.findAll();
    }
}
