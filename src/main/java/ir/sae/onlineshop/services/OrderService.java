package ir.sae.onlineshop.services;

import ir.sae.onlineshop.base.BaseService;
import ir.sae.onlineshop.entities.OrderEntity;

import java.util.List;

public interface OrderService extends BaseService<OrderEntity, Long> {
//    OrderEntity saveOrder(OrderEntity orderEntity);
//
//    OrderEntity updateOrder(OrderEntity orderEntity);
//
//    List<OrderEntity> findAll();
//
//    OrderEntity findById(OrderEntity orderEntity);
//
//    void deleteById(OrderEntity orderEntity);

    List<OrderEntity> findByExample(OrderEntity orderEntity);

}
