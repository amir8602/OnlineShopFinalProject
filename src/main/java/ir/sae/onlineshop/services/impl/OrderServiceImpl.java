package ir.sae.onlineshop.services.impl;

import ir.sae.onlineshop.base.BaseServiceImpl;
import ir.sae.onlineshop.entities.OrderEntity;
import ir.sae.onlineshop.repositories.OrderRepository;
import ir.sae.onlineshop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class OrderServiceImpl extends BaseServiceImpl<OrderRepository, OrderEntity,Long > implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository repository) {
        super(repository);
    }

    @Override
    public List<OrderEntity> findByExample(OrderEntity orderEntity) {
        return orderRepository.findAll(Example.of(orderEntity));
    }
}
