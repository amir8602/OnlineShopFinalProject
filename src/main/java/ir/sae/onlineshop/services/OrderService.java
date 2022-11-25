package ir.sae.onlineshop.services;

import ir.sae.onlineshop.entities.OrderEntity;

import java.util.List;

public interface OrderService {


    List<OrderEntity> findByExample(OrderEntity orderEntity);

}
