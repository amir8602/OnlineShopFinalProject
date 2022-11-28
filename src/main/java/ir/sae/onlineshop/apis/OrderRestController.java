package ir.sae.onlineshop.apis;

import ir.sae.onlineshop.base.BaseRestController;
import ir.sae.onlineshop.dto.IsNotNull;
import ir.sae.onlineshop.dto.OrderDto;
import ir.sae.onlineshop.dto.composit.AddOrderDto;
import ir.sae.onlineshop.entities.OrderEntity;
import ir.sae.onlineshop.mappers.OrderMapper;
import ir.sae.onlineshop.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderRestController extends BaseRestController<
        OrderDto, OrderEntity, OrderMapper, OrderService, Long> {


    @Autowired
    private OrderService orderService;



    @Autowired
    private OrderMapper orderMapper;

    public OrderRestController(OrderService service, OrderMapper mapper) {
        super(service, mapper);
    }

    @PostMapping("/addProduct")
    public OrderEntity addToOrder(@RequestBody @Validated(IsNotNull.class) AddOrderDto addOrderDto){
        return orderService.addToOrder(addOrderDto);
    }


}
