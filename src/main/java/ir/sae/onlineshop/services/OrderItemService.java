package ir.sae.onlineshop.services;

import ir.sae.onlineshop.base.BaseService;
import ir.sae.onlineshop.entities.OrderItemEntity;


public interface OrderItemService extends BaseService<OrderItemEntity, Long>{

//    OrderItemEntity saveOrderItem(OrderItemEntity orderItemEntity);
//    OrderItemEntity getOrderItemById(OrderItemEntity orderItemEntity);
//    OrderItemEntity updateOrderItem(OrderItemEntity orderItemEntity);
//    void deleteOrderItem(Long id);
    void deleteAllOrderItem(OrderItemEntity orderItemEntity);
//    List<OrderItemEntity> findAllOrderItemByOrder(OrderEntity orderEntity);
//    List<OrderItemEntity> getAll();
}
