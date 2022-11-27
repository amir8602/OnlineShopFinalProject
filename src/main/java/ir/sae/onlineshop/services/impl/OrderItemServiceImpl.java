package ir.sae.onlineshop.services.impl;


import ir.sae.onlineshop.base.BaseServiceImpl;
import ir.sae.onlineshop.entities.OrderItemEntity;
import ir.sae.onlineshop.repositories.OrderItemRepository;
import ir.sae.onlineshop.repositories.OrderRepository;
import ir.sae.onlineshop.services.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl extends BaseServiceImpl<OrderItemEntity,
        Long, OrderItemRepository> implements OrderItemService {
    @Autowired
    OrderItemRepository orderItemRepository;
    @Autowired
    OrderRepository orderRepository;


    //    @Override
//    public OrderItemEntity saveOrderItem(OrderItemEntity orderItemEntity) {
//        return orderItemRepository.save(orderItemEntity);
//    }
//
//    @Override
//    public OrderItemEntity getOrderItemById(OrderItemEntity orderItemEntity) {
//        return orderItemRepository.findById(orderItemEntity.getId()).get();
//    }
//
//    @Override
//    public OrderItemEntity updateOrderItem(OrderItemEntity orderItemEntity) {
//        return orderItemRepository.save(orderItemEntity);
//    }
//
//    @Override
//    public void deleteOrderItem(Long id) {
//        orderItemRepository.deleteById(id);
//
//    }
//    @Override
//    public List<OrderItemEntity> getAll() {
//        return orderItemRepository.findAll();
//    }
    @Override
    public void deleteAllOrderItem(OrderItemEntity orderItemEntity) {

        orderRepository.deleteAll();
    }


}
