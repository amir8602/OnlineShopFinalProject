package ir.sae.onlineshop.services.impl;


import ir.sae.onlineshop.models.order.OrderEntity;
import ir.sae.onlineshop.models.orderItem.OrderItemEntity;
import ir.sae.onlineshop.models.orderItem.dao.OrderItemDao;
import ir.sae.onlineshop.services.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    OrderItemDao orderItemDao;

    @Override
    public OrderItemEntity saveOrderItem(OrderItemEntity orderItemEntity) {
        return orderItemDao.save(orderItemEntity);
    }

    @Override
    public OrderItemEntity getOrderItemById(OrderItemEntity orderItemEntity) {
        return orderItemDao.findById(orderItemEntity.getId()).get();
    }

    @Override
    public OrderItemEntity updateOrderItem(OrderItemEntity orderItemEntity) {
        return orderItemDao.save(orderItemEntity);
    }

    @Override
    public void deleteOrderItem(Long id) {
        orderItemDao.deleteById(id);

    }

    @Override
    public void deleteAllOrderItem(OrderItemEntity orderItemEntity) {


    }

    @Override
    public List<OrderItemEntity> findAllOrderItemByOrder(OrderEntity orderEntity) {
        return null;
    }

    @Override
    public List<OrderItemEntity> getAll() {
        return orderItemDao.findAll();
    }
}
