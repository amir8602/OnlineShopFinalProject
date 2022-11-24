package ir.sae.onlineshop.models.orderItem.dao;

import ir.sae.onlineshop.models.orderItem.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderItemDao extends JpaRepository<OrderItemEntity,Long> {


   OrderItemEntity save(OrderItemEntity orderItemEntity);

    List<OrderItemEntity> findAll();

    Optional<OrderItemEntity> findById(Long aLong);
    void deleteById(Long aLong);


    void deleteAllInBatch(Iterable<OrderItemEntity> entities);
}
