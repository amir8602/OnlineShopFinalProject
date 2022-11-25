package ir.sae.onlineshop.services;

import ir.sae.onlineshop.entities.OrderEntity;
import ir.sae.onlineshop.entities.OrderItemEntity;

import java.util.List;


public interface OrderItemService {


    void deleteAllOrderItem(OrderItemEntity orderItemEntity);
    List<OrderItemEntity> findAllOrderItemByOrder(OrderEntity orderEntity);

}
