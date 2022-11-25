package ir.sae.onlineshop.repositories;

import ir.sae.onlineshop.entities.ProductEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    <S extends ProductEntity> S save(S entity);


    ProductEntity getById(Long aLong);


    List<ProductEntity> findAll();


    void deleteById(Long aLong);


    <S extends ProductEntity> List<S> findAll(Example<S> example);
}
