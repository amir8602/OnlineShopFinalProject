package ir.sae.onlineshop.services.impl;

import ir.sae.onlineshop.entities.OrderEntity;
import ir.sae.onlineshop.exceptions.BaseException;
import ir.sae.onlineshop.repositories.OrderRepository;
import ir.sae.onlineshop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;
    @Override
    public OrderEntity saveOrder(OrderEntity orderEntity) {
        return orderRepository.save(orderEntity);
    }

    @Override
    public OrderEntity updateOrder(OrderEntity orderEntity) {
        return orderRepository.save(orderEntity);
    }

    @Override
    public List<OrderEntity> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public OrderEntity findById(OrderEntity orderEntity) throws BaseException {
        try {
            OrderEntity orderEntity1 = orderRepository.findById(orderEntity.getId()).get();
        }catch (NoSuchElementException e){
//            Logger
            throw new BaseException("Entity not found" , e.getCause() , "NoSuchElementException"  );
        }

        return null;
    }

    @Override
    public void deleteById(OrderEntity orderEntity) {
        orderRepository.deleteById(orderEntity.getId());
    }

    @Override
    public List<OrderEntity> findByExample(OrderEntity orderEntity) {
        return orderRepository.findAll(Example.of(orderEntity));
    }
}
