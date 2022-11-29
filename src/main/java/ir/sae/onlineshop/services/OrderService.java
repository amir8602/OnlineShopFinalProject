package ir.sae.onlineshop.services;

import ir.sae.onlineshop.base.BaseService;
import ir.sae.onlineshop.dto.composit.AddOrderDto;
import ir.sae.onlineshop.entities.OrderEntity;

public interface OrderService extends BaseService<OrderEntity, Long> {

    public OrderEntity addToOrder(AddOrderDto addOrderDto);
    public OrderEntity deleteFromOrder(Long id);

}
