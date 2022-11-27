

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


//    @PostMapping
//    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
//    public OrderItemDto saveOrderItem(@RequestBody OrderItemDto orderItemDto) {
//        OrderItemEntity orderItemEntity = orderItemMapper.dtoToEntityConvertor(orderItemDto);
//        OrderItemEntity saveOrderItemEntity = orderItemService.saveOrderItem(orderItemEntity);
//        OrderItemDto saveOrderItemDto = orderItemMapper.entityToDtoConvertor(saveOrderItemEntity);
//        return saveOrderItemDto;
//    }
//
//    @GetMapping("/{id}")
//    @PreAuthorize("hasRole('ADMIN')")
//    public OrderItemDto getOrderItemById(@PathVariable("id") Long id) {
//        OrderItemEntity orderItemEntity = new OrderItemEntity(id);
//        OrderItemEntity orderItemById = orderItemService.getOrderItemById(orderItemEntity);
//        OrderItemDto getOrderItemDto = orderItemMapper.entityToDtoConvertor(orderItemById);
//        return getOrderItemDto;
//    }
//
//    @GetMapping
//    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
//    public List<OrderItemDto> getAllOrderItem() {
//        List<OrderItemEntity> getAllOrderItem = orderItemService.getAll();
//        List<OrderItemDto> getAllOrderItemDtos = orderItemMapper.entityToDtoConvertor(getAllOrderItem);
//        return getAllOrderItemDtos;
//
//    }
//
//    @PutMapping
//    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
//    public OrderItemDto updateOrderItem(@RequestBody OrderItemDto orderItemDto) {
//        OrderItemEntity orderItemEntity = orderItemMapper.dtoToEntityConvertor(orderItemDto);
//        OrderItemEntity updateOrderItemEntity = orderItemService.updateOrderItem(orderItemEntity);
//        OrderItemDto updateOrderItemDto = orderItemMapper.entityToDtoConvertor(updateOrderItemEntity);
//        return updateOrderItemDto;
//    }
//
//    @DeleteMapping("/{id}")
//    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
//    public void deleteOrderItem(@PathVariable("id") Long id) {
//
//        OrderItemEntity orderItemEntity = new OrderItemEntity(id);
//
//
//        orderItemService.deleteOrderItem(orderItemEntity.getId());
//
//    }
//
//    @DeleteMapping
//    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
//    public void deleteAllOrderItem(@RequestBody OrderItemDto orderItemDto) {
//
//        OrderItemEntity orderItemEntity = orderItemMapper.dtoToEntityConvertor(orderItemDto);
//
//        orderItemService.deleteAllOrderItem(orderItemEntity);
//
//
//    }


}
