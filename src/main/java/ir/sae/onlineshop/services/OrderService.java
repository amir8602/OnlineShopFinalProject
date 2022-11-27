package ir.sae.onlineshop.services;

import ir.sae.onlineshop.entities.OrderEntity;
import ir.sae.onlineshop.exceptions.BaseException;

import java.util.List;

public interface OrderService {
    OrderEntity saveOrder(OrderEntity orderEntity);

    OrderEntity updateOrder(OrderEntity orderEntity);

    List<OrderEntity> findAll();

    OrderEntity findById(OrderEntity orderEntity)throws BaseException;

    void deleteById(OrderEntity orderEntity);

    List<OrderEntity> findByExample(OrderEntity orderEntity);

}
