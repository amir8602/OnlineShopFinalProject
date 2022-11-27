package ir.sae.onlineshop.services.impl;

import ir.sae.onlineshop.OnlineShopApplication;
import ir.sae.onlineshop.entities.OrderItemEntity;
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

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = OnlineShopApplication.class)
@EnableTransactionManagement
class OrderItemServiceImplTest {

    @Autowired
    private OrderItemServiceImpl orderItemService;

    @BeforeEach
    void setUp() {
        OrderItemEntity orderItemEntity=new OrderItemEntity();
        orderItemEntity.setQuantity(12);
        orderItemEntity.setTotalPrice(123.5);
        OrderItemEntity orderItemEntitySave = orderItemService.saveOrderItem(orderItemEntity);
        OrderItemEntity orderItemEntity1=new OrderItemEntity();
        orderItemEntity1.setQuantity(32);
        orderItemEntity1.setTotalPrice(235);
        OrderItemEntity orderItemEntitySave2 = orderItemService.saveOrderItem(orderItemEntity1);
        OrderItemEntity orderItemEntity2=new OrderItemEntity();
        orderItemEntity1.setQuantity(9);
        orderItemEntity1.setTotalPrice(243);
        OrderItemEntity orderItemEntity3 = orderItemService.saveOrderItem(orderItemEntity2);
    }
    @Test
    void save() {
        OrderItemEntity orderItemEntity=new OrderItemEntity();
        orderItemEntity.setQuantity(12);
        orderItemEntity.setTotalPrice(123.5);
        OrderItemEntity save = orderItemService.saveOrderItem(orderItemEntity);
        OrderItemEntity orderItemById = orderItemService.getOrderItemById(save);
        assertSame(save.getId(), orderItemById.getId());
    }

        @Test
    void getById() {
        Assertions.assertThrows(NullPointerException.class,() ->
                orderItemService.getOrderItemById(null));
  }

    @Test
    void updateOrderItem() {
        OrderItemEntity orderItemById = orderItemService.getOrderItemById(new OrderItemEntity(1l));
        orderItemById.setTotalPrice(210.0);
        OrderItemEntity orderItemEntity = orderItemService.updateOrderItem(orderItemById);
        assertEquals(210.0, orderItemEntity.getTotalPrice());
    }

    @Test
    void deleteOrderItem() {

        orderItemService.deleteOrderItem(2l);
        List<OrderItemEntity> all = orderItemService.getAll();
        Assertions.assertEquals(2,all.size());

    }

    @Test
    void getAll() {
        List<OrderItemEntity> all = orderItemService.getAll();
        Assertions.assertEquals(3, all.size());
    }






}