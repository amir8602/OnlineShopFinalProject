package ir.sae.onlineshop.services;

import ir.sae.onlineshop.entities.ProductEntity;
import org.springframework.data.domain.Example;

import java.util.List;

public interface ProductService {


    List<ProductEntity> searchByExample(Example<ProductEntity> of);
}
