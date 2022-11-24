package ir.sae.onlineshop.services;

import ir.sae.onlineshop.models.order.OrderEntity;

import java.util.List;

public interface OrderService {
    OrderEntity saveOrder(OrderEntity orderEntity);

    OrderEntity updateOrder(OrderEntity orderEntity);

    List<OrderEntity> findAll();

    OrderEntity findById(OrderEntity orderEntity);

    void deleteById(OrderEntity orderEntity);

    List<OrderEntity> findByExample(OrderEntity orderEntity);

}
