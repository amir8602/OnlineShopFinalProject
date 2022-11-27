package ir.sae.onlineshop.services.impl;

import ir.sae.onlineshop.entities.OrderEntity;
import ir.sae.onlineshop.entities.UserEntity;
import ir.sae.onlineshop.enums.OrderStatus;
import ir.sae.onlineshop.repositories.OrderRepository;
import ir.sae.onlineshop.services.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class OrderServiceImplTest {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderRepository orderRepository;

    @BeforeEach
    void setUp() {
        OrderEntity orderEntity=new OrderEntity();
        orderEntity.setUser(new UserEntity("erf"));
        orderEntity.setOrderStatus(OrderStatus.CANCELLED);
        orderService.saveOrder(orderEntity);
        OrderEntity orderEntity1=new OrderEntity();
        orderEntity1.setUser(new UserEntity("amir"));
        orderEntity1.setOrderStatus(OrderStatus.COMPLETED);
        orderService.saveOrder(orderEntity1);
    }

    @Test
    void saveOrder() {
        OrderEntity orderEntity=new OrderEntity();
        orderEntity.setUser(new UserEntity("req"));
        orderEntity.setOrderStatus(OrderStatus.CANCELLED);
        OrderEntity saveOrder = orderService.saveOrder(orderEntity);

        Assertions.assertEquals(saveOrder.getOrderStatus(),orderEntity.getOrderStatus());
    }

    @Test
    void updateOrder() {
        OrderEntity byId = orderService.findById(new OrderEntity(1L));
        byId.setGrandTotal(12);
        OrderEntity orderEntity = orderService.updateOrder(byId);
        assertEquals(13, orderEntity.getGrandTotal());

    }
    //?
    @Test
    void findAll() {
        List<OrderEntity> all = orderService.findAll();

        Assertions.assertEquals(2,all.size());
    }

    @Test
    void findById() {
        Assertions.assertThrows(NullPointerException.class,() -> orderService.findById(null));
    }
//?
    @Test
    void deleteById() {
        OrderEntity orderEntity=new OrderEntity();
        orderEntity.setGrandTotal(12);
        orderService.deleteById(new OrderEntity(1l));
        assertNull(orderService.findById(new OrderEntity(1L)).getGrandTotal());

    }
//?

}