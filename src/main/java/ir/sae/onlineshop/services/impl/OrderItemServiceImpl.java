package ir.sae.onlineshop.services.impl;


import ir.sae.onlineshop.base.BaseServiceImpl;
import ir.sae.onlineshop.entities.OrderEntity;
import ir.sae.onlineshop.entities.OrderItemEntity;
import ir.sae.onlineshop.repositories.OrderItemRepository;
import ir.sae.onlineshop.services.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class OrderItemServiceImpl extends BaseServiceImpl<OrderItemRepository , OrderItemEntity ,Long > implements OrderItemService {

    @Autowired
    OrderItemRepository orderItemRepository;

    public OrderItemServiceImpl(OrderItemRepository repository) {
        super(repository);
    }

    @Override
    public void deleteAllOrderItem(OrderItemEntity orderItemEntity) {


    }

    @Override
    public List<OrderItemEntity> findAllOrderItemByOrder(OrderEntity orderEntity) {
        return null;
    }


}
