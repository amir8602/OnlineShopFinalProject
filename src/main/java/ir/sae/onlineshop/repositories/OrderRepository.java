package ir.sae.onlineshop.repositories;

import ir.sae.onlineshop.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity,Long> {


}
