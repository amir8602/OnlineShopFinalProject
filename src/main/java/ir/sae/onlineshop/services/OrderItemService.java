package ir.sae.onlineshop.services;

import ir.sae.onlineshop.entities.OrderEntity;
import ir.sae.onlineshop.entities.OrderItemEntity;

import java.util.List;


public interface OrderItemService {

    OrderItemEntity saveOrderItem(OrderItemEntity orderItemEntity);
    OrderItemEntity getOrderItemById(OrderItemEntity orderItemEntity);
    OrderItemEntity updateOrderItem(OrderItemEntity orderItemEntity);
    void deleteOrderItem(Long id);
    void deleteAllOrderItem(OrderItemEntity orderItemEntity);
    List<OrderItemEntity> findAllOrderItemByOrder(OrderEntity orderEntity);
    List<OrderItemEntity> getAll();
}
