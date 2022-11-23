package ir.sae.onlineshop.models.product.dao;


import ir.sae.onlineshop.models.product.ProductEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductDao extends JpaRepository<ProductEntity, Long> {


    ProductEntity save(ProductEntity productEntity);

    void deleteById(Long aLong);

    <S extends ProductEntity> List<S> findAll(Example<S> var1);



    Optional<ProductEntity> findById(Long aLong);
}
