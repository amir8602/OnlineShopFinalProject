package ir.sae.onlineshop.services;

import ir.sae.onlineshop.entities.OrderEntity;
import ir.sae.onlineshop.entities.OrderItemEntity;
import ir.sae.onlineshop.exceptions.BaseException;

import java.util.List;


public interface OrderItemService {

    OrderItemEntity saveOrderItem(OrderItemEntity orderItemEntity)throws BaseException;
    OrderItemEntity getOrderItemById(OrderItemEntity orderItemEntity)throws BaseException;
    OrderItemEntity updateOrderItem(OrderItemEntity orderItemEntity)throws BaseException;
    void deleteOrderItem(Long id)throws BaseException;
    void deleteAllOrderItem(OrderItemEntity orderItemEntity)throws BaseException;
    List<OrderItemEntity> findAllOrderItemByOrder(OrderEntity orderEntity)throws BaseException;
    List<OrderItemEntity> getAll()throws BaseException;
}
