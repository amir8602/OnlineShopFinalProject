package ir.sae.onlineshop.services.impl;


import ir.sae.onlineshop.base.BaseServiceImpl;
import ir.sae.onlineshop.entities.OrderItemEntity;
import ir.sae.onlineshop.repositories.OrderItemRepository;
import ir.sae.onlineshop.repositories.OrderRepository;
import ir.sae.onlineshop.services.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl extends BaseServiceImpl<OrderItemEntity,
        Long, OrderItemRepository> implements OrderItemService {
    @Autowired
    OrderItemRepository orderItemRepository;
    @Autowired
    OrderRepository orderRepository;

}
