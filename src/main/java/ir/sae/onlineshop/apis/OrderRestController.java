package ir.sae.onlineshop.apis;

import ir.sae.onlineshop.dto.OrderDto;
import ir.sae.onlineshop.entities.OrderEntity;
import ir.sae.onlineshop.entities.UserEntity;
import ir.sae.onlineshop.exceptions.BaseException;
import ir.sae.onlineshop.mappers.OrderMapper;
import ir.sae.onlineshop.services.OrderItemService;
import ir.sae.onlineshop.services.OrderService;
import ir.sae.onlineshop.services.ProductService;
import ir.sae.onlineshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderRestController {


    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderItemService orderItemService;

    @Autowired
    private UserService userService;


    @PostMapping
    public OrderDto saveOrder(@RequestBody OrderDto orderDto) {
        return orderMapper.entityToDtoConvertor(orderService.saveOrder(orderMapper.dtoToEntityConvertor(orderDto)));
    }

    @PutMapping
    public OrderDto updateOrder(@RequestBody OrderDto orderDto) {
        return orderMapper.entityToDtoConvertor(orderService.updateOrder(orderMapper.dtoToEntityConvertor(orderDto)));
    }

    @GetMapping
    public List<OrderDto> findAll() {
        return orderMapper.entityToDtoConvertor(orderService.findAll());
    }

    @GetMapping("/{id}")
    public OrderDto findById(@PathVariable Long id) throws BaseException {
        return orderMapper.entityToDtoConvertor(orderService.findById(new OrderEntity(id)));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        orderService.deleteById(new OrderEntity(id));
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("/addToOrder/{id}")
    public UserEntity addToOrder(@PathVariable("id") Long id, Principal principal) {
        String name = principal.getName();
        UserEntity byUsername = userService.getByUsername(new UserEntity(name));
        return byUsername;
//        ProductEntity byId = productService.getById(new ProductEntity(id));
//        OrderItemEntity orderItemEntity = new OrderItemEntity();
////        orderItemService.saveOrderItem();
//
//        return null;
    }


}
