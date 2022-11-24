package ir.sae.onlineshop.models.order.dao;

import ir.sae.onlineshop.models.order.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<OrderEntity,Long> {


}
