package ir.sae.onlineshop.services.impl;

import ir.sae.onlineshop.base.BaseServiceImpl;
import ir.sae.onlineshop.entities.ProductEntity;
import ir.sae.onlineshop.repositories.ProductRepository;
import ir.sae.onlineshop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl  extends BaseServiceImpl<ProductEntity,
        Long, ProductRepository> implements ProductService {


    @Autowired
    private ProductRepository productRepository;

}
