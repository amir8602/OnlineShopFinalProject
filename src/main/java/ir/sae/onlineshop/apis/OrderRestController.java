package ir.sae.onlineshop.apis;

import ir.sae.onlineshop.base.BaseController;
import ir.sae.onlineshop.dto.OrderDto;
import ir.sae.onlineshop.entities.OrderEntity;
import ir.sae.onlineshop.mappers.OrderMapper;
import ir.sae.onlineshop.services.OrderService;
import ir.sae.onlineshop.services.impl.OrderItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderRestController extends BaseController<OrderDto,OrderEntity
        ,OrderMapper, OrderItemServiceImpl> {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderMapper orderMapper;

    public OrderRestController(OrderItemServiceImpl service, OrderMapper mapper) {
        super(service, mapper);
    }

//    @PostMapping
//    public OrderDto saveOrder(@RequestBody OrderDto orderDto){
//        return orderMapper.entityToDtoConvertor(orderService.saveOrder(orderMapper.dtoToEntityConvertor(orderDto)));
//    }
//
//    @PutMapping
//    public OrderDto updateOrder(@RequestBody OrderDto orderDto){
//        return orderMapper.entityToDtoConvertor(orderService.updateOrder(orderMapper.dtoToEntityConvertor(orderDto)));
//    }
//
//    @GetMapping
//    public List<OrderDto> findAll(){
//        return orderMapper.entityToDtoConvertor(orderService.findAll());
//    }
//
//    @GetMapping("/{id}")
//    public OrderDto findById(@PathVariable Long id){
//        return orderMapper.entityToDtoConvertor(orderService.findById(new OrderEntity(id)));
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteById(@PathVariable Long id){
//        orderService.deleteById(new OrderEntity(id));
//    }
//}
}