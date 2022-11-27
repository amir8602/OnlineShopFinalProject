package ir.sae.onlineshop.services.impl;

import ir.sae.onlineshop.base.BaseServiceImpl;
import ir.sae.onlineshop.entities.OrderEntity;
import ir.sae.onlineshop.repositories.OrderRepository;
import ir.sae.onlineshop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl extends BaseServiceImpl<OrderEntity,
        Long, OrderRepository> implements OrderService {

    @Autowired
    OrderRepository orderRepository;


 

//    @Override
//    public OrderEntity saveOrder(OrderEntity orderEntity) {
//        return orderRepository.save(orderEntity);
//    }
//
//    @Override
//    public OrderEntity updateOrder(OrderEntity orderEntity) {
//        return orderRepository.save(orderEntity);
//    }
//
//    @Override
//    public List<OrderEntity> findAll() {
//        return orderRepository.findAll();
//    }
//
//    @Override
//    public OrderEntity findById(OrderEntity orderEntity) {
//
//        return orderRepository.findById(orderEntity.getId()).get();
//    }
//
//    @Override
//    public void deleteById(OrderEntity orderEntity) {
//        orderRepository.deleteById(orderEntity.getId());
//
//    }

//    @Override
//    public OrderEntity getOrderGrandTotal(long orderId) {
//
//        double grandTotal=0;
//        Optional<OrderEntity> findById =orderRepository.findById(orderId);
//        List<OrderItemEntity> findOrderItem = findById.get().getOrderItem();
//        for (OrderItemEntity orderItemEntity : findOrderItem) {
//            grandTotal += orderItemEntity.getTotalPrice();
//          return null;
//
//
//        }
//
//    }

    @Override
    public List<OrderEntity> findByExample(OrderEntity orderEntity) {
        return orderRepository.findAll(Example.of(orderEntity));
    }
}
