package ir.sae.onlineshop.services.impl;

import ir.sae.onlineshop.base.BaseServiceImpl;
import ir.sae.onlineshop.dto.composit.AddOrderDto;
import ir.sae.onlineshop.entities.OrderEntity;
import ir.sae.onlineshop.entities.OrderItemEntity;
import ir.sae.onlineshop.entities.ProductEntity;
import ir.sae.onlineshop.entities.UserEntity;
import ir.sae.onlineshop.enums.OrderStatus;
import ir.sae.onlineshop.exceptions.BaseException;
import ir.sae.onlineshop.repositories.OrderRepository;
import ir.sae.onlineshop.services.OrderItemService;
import ir.sae.onlineshop.services.OrderService;
import ir.sae.onlineshop.services.ProductService;
import ir.sae.onlineshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl extends BaseServiceImpl<OrderEntity,
        Long, OrderRepository> implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderItemService orderItemService;


    @Override
    public OrderEntity addToOrder(AddOrderDto addOrderDto) throws BaseException {
        List<ProductEntity> all = productService.findAll(new ProductEntity(addOrderDto.getProductId()));
        ProductEntity productEntity;
        OrderEntity save;
        if (all.size() > 0) {
            productEntity = all.get(0);
        } else {
            throw new BaseException("Product Not Found", "Product Not Found");
        }
        if (productEntity.getUnitInStock() < addOrderDto.getCount()) {
            throw new BaseException("Out Of Bound", "Out Of Bound");
        } else {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String currentPrincipalName = authentication.getName();
            UserEntity byUsername = userService.findByUsername(new UserEntity(currentPrincipalName));
            if (byUsername.getOrder() == null) {
                byUsername.setOrder(new OrderEntity(0.0, byUsername, OrderStatus.IN_PROGRESS));
                userService.saveOrUpdate(byUsername);
            }
            OrderEntity order = userService.findByUsername(new UserEntity(currentPrincipalName)).getOrder();
            OrderItemEntity orderItemEntity = new OrderItemEntity();
            orderItemEntity.setProduct(all.get(0));
            orderItemEntity.setOrder(order);
            orderItemEntity.setQuantity(Math.toIntExact(addOrderDto.getCount()));
            orderItemEntity.setTotalPrice(all.get(0).getProductPrice().doubleValue() * addOrderDto.getCount());
            order.getOrderItems().add(orderItemEntity);
            order.setGrandTotal(order.getGrandTotal() + all.get(0).getProductPrice().doubleValue() * addOrderDto.getCount());
            save = orderRepository.save(order);
            productEntity.setUnitInStock((int) (productEntity.getUnitInStock() - addOrderDto.getCount()));
            productService.saveOrUpdate(productEntity);
        }
        return save;
    }


    @Override
    public OrderEntity deleteFromOrder(Long id) throws BaseException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        OrderEntity order = userService.findByUsername(new UserEntity(currentPrincipalName)).getOrder();
        List<OrderItemEntity> orderItem = order.getOrderItems();
        OrderItemEntity remove = new OrderItemEntity();
        for (int i = 0; i < orderItem.size(); i++) {
            if (orderItem.get(i).getId().equals(id)){
                orderItemService.deleteById(orderItem.get(i).getId());
                remove = orderItem.remove(i);
                order.setOrderItems(orderItem);
                order.setGrandTotal(order.getGrandTotal() - (remove.getTotalPrice() * remove.getQuantity()));
                order = orderRepository.save(order);
            }
        }
        return order;
    }

}
