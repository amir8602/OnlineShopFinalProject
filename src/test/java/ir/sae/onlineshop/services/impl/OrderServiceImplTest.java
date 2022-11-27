package ir.sae.onlineshop.services.impl;

import ir.sae.onlineshop.OnlineShopApplication;
import ir.sae.onlineshop.entities.OrderEntity;
import ir.sae.onlineshop.entities.UserEntity;
import ir.sae.onlineshop.enums.OrderStatus;
import ir.sae.onlineshop.repositories.OrderRepository;
import ir.sae.onlineshop.services.OrderService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = OnlineShopApplication.class)
@EnableTransactionManagement
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

    @AfterEach
    void tearDown() {
        orderRepository.deleteAll();
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
    void findAll() {
        List<OrderEntity> all = orderService.findAll();

        Assertions.assertEquals(2,all.size());
    }
}