package ir.sae.onlineshop.services.impl;

import ir.sae.onlineshop.models.order.OrderEntity;
import ir.sae.onlineshop.models.order.dao.OrderDao;
import ir.sae.onlineshop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;
    @Override
    public OrderEntity saveOrder(OrderEntity orderEntity) {
        return orderDao.save(orderEntity);
    }

    @Override
    public OrderEntity updateOrder(OrderEntity orderEntity) {
        return orderDao.save(orderEntity);
    }

    @Override
    public List<OrderEntity> findAll() {
        return orderDao.findAll();
    }

    @Override
    public OrderEntity findById(OrderEntity orderEntity) {
        return orderDao.findById(orderEntity.getId()).get();
    }

    @Override
    public void deleteById(OrderEntity orderEntity) {
        orderDao.deleteById(orderEntity.getId());

    }

    @Override
    public List<OrderEntity> findByExample(OrderEntity orderEntity) {
        return orderDao.findAll(Example.of(orderEntity));
    }
}
