package ir.sae.onlineshop.apis;

import ir.sae.onlineshop.dto.OrderDto;
import ir.sae.onlineshop.mappers.OrderMapper;
import ir.sae.onlineshop.entities.OrderEntity;
import ir.sae.onlineshop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderRestController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderMapper orderMapper;

    @PostMapping
    public OrderDto saveOrder(@RequestBody OrderDto orderDto){
        return orderMapper.entityToModelConvertor(orderService.saveOrder(orderMapper.modelToEntityConvertor(orderDto)));
    }

    @PutMapping
    public OrderDto updateOrder(@RequestBody OrderDto orderDto){
        return orderMapper.entityToModelConvertor(orderService.updateOrder(orderMapper.modelToEntityConvertor(orderDto)));
    }

    @GetMapping
    public List<OrderDto> findAll(){
        return orderMapper.entityToModelConvertor(orderService.findAll());
    }

    @GetMapping("/{id}")
    public OrderDto findById(@PathVariable Long id){
        return orderMapper.entityToModelConvertor(orderService.findById(new OrderEntity(id)));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        orderService.deleteById(new OrderEntity(id));
    }
}