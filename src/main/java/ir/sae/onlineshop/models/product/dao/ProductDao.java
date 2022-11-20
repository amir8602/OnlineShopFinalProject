package ir.sae.onlineshop.models.product.dao;

import ir.sae.onlineshop.models.product.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<ProductEntity, Long> {

    <S extends ProductEntity> S save(S entity);


    ProductEntity getById(Long aLong);


    List<ProductEntity> findAll();
}
