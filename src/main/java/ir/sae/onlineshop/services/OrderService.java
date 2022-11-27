package ir.sae.onlineshop.services;

import ir.sae.onlineshop.entities.OrderEntity;
import ir.sae.onlineshop.exceptions.BaseException;

import java.util.List;

public interface OrderService {
    OrderEntity saveOrder(OrderEntity orderEntity)throws BaseException;

    OrderEntity updateOrder(OrderEntity orderEntity)throws BaseException;

    List<OrderEntity> findAll()throws BaseException;

    OrderEntity findById(OrderEntity orderEntity)throws BaseException;

    void deleteById(OrderEntity orderEntity)throws BaseException;

    List<OrderEntity> findByExample(OrderEntity orderEntity)throws BaseException;

}
