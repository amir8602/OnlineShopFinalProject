package ir.sae.onlineshop.apis.webRestApis;

import ir.sae.onlineshop.mappers.OrderMapper;
import ir.sae.onlineshop.models.order.OrderEntity;
import ir.sae.onlineshop.models.order.OrderModel;
import ir.sae.onlineshop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderRestController {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderMapper orderMapper;

    @PostMapping
    public OrderModel saveOrder(@RequestBody OrderModel orderModel){
        return orderMapper.entityToModelConvertor(orderService.saveOrder(orderMapper.modelToEntityConvertor(orderModel)));
    }

    @PutMapping
    public OrderModel updateOrder(@RequestBody OrderModel orderModel){
        return orderMapper.entityToModelConvertor(orderService.updateOrder(orderMapper.modelToEntityConvertor(orderModel)));
    }

    @GetMapping
    public List<OrderModel> findAll(){
        return orderMapper.entityToModelConvertor(orderService.findAll());
    }

    @GetMapping("/{id}")
    public OrderModel findById(@PathVariable Long id){
        return orderMapper.entityToModelConvertor(orderService.findById(new OrderEntity(id)));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        orderService.deleteById(new OrderEntity(id));
    }
}
