package ir.sae.onlineshop.services.impl;

import ir.sae.onlineshop.base.BaseServiceImpl;
import ir.sae.onlineshop.entities.ProductEntity;
import ir.sae.onlineshop.repositories.ProductRepository;
import ir.sae.onlineshop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ProductServiceImpl extends BaseServiceImpl<ProductRepository, ProductEntity,Long > implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository repository) {
        super(repository);
    }


    @Override
    public List<ProductEntity> searchByExample(Example<ProductEntity> of) {
        return productRepository.findAll(of);
    }
}
