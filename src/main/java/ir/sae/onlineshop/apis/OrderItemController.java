

package ir.sae.onlineshop.apis;

import ir.sae.onlineshop.base.BaseRestController;
import ir.sae.onlineshop.dto.OrderItemDto;
import ir.sae.onlineshop.entities.OrderItemEntity;
import ir.sae.onlineshop.mappers.OrderItemMapper;
import ir.sae.onlineshop.services.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/order/items")

public class OrderItemController extends BaseRestController<
        OrderItemDto, OrderItemEntity, OrderItemMapper, OrderItemService, Long> {

    public OrderItemController(OrderItemService service, OrderItemMapper mapper) {
        super(service, mapper);
    }

    @Autowired
    OrderItemService orderItemService;

    @Autowired
    OrderItemMapper orderItemMapper;

}
