package ir.sae.onlineshop.repositories;

import ir.sae.onlineshop.entities.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItemEntity,Long> {


   OrderItemEntity save(OrderItemEntity orderItemEntity);

    List<OrderItemEntity> findAll();

    Optional<OrderItemEntity> findById(Long aLong);
    void deleteById(Long aLong);


    void deleteAllInBatch(Iterable<OrderItemEntity> entities);
}
