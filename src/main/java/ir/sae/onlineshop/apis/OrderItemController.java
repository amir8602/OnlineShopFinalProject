

package ir.sae.onlineshop.apis;

import ir.sae.onlineshop.dto.OrderDto;
import ir.sae.onlineshop.dto.OrderItemDto;
import ir.sae.onlineshop.mappers.OrderItemMapper;
import ir.sae.onlineshop.entities.OrderItemEntity;
import ir.sae.onlineshop.services.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/orderItems")
public class OrderItemController {



  @Autowired
  OrderItemService orderItemService;



  @Autowired
  OrderItemMapper orderItemMapper;


    @PostMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public OrderItemDto saveOrderItem(@RequestBody OrderItemDto orderItemDto) {
        OrderItemEntity orderItemEntity = orderItemMapper.dtoToEntityConvertor(orderItemDto);
        OrderItemEntity saveOrderItemEntity = orderItemService.saveOrderItem(orderItemEntity);
        OrderItemDto saveOrderItemDto = orderItemMapper.entityToDtoConvertor(saveOrderItemEntity);
        return saveOrderItemDto;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public OrderItemDto getOrderItemById(@PathVariable("id") Long id) {
        OrderItemEntity orderItemEntity = new OrderItemEntity(id);
        OrderItemEntity orderItemById = orderItemService.getOrderItemById(orderItemEntity);
         OrderItemDto getOrderItemDto = orderItemMapper.entityToDtoConvertor(orderItemById);
        return getOrderItemDto;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public List<OrderItemDto> getAllOrderItem() {
        List<OrderItemEntity> getAllOrderItem = orderItemService.getAll();
        List<OrderItemDto> getAllOrderItemDtos = orderItemMapper.entityToDtoConvertor(getAllOrderItem);
        return getAllOrderItemDtos;

    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public OrderItemDto updateOrderItem(@RequestBody OrderItemDto orderItemDto) {
        OrderItemEntity orderItemEntity = orderItemMapper.dtoToEntityConvertor(orderItemDto);
        OrderItemEntity updateOrderItemEntity = orderItemService.updateOrderItem(orderItemEntity);
        OrderItemDto updateOrderItemDto = orderItemMapper.entityToDtoConvertor(updateOrderItemEntity);
        return updateOrderItemDto;
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public String deleteOrderItem(@PathVariable("id") Long id) {

        OrderItemEntity orderItemEntity = new OrderItemEntity(id);

        try {
            orderItemService.deleteOrderItem(orderItemEntity.getId());
        } catch (Exception e) {
            return "orderItem is not found!";
        }
        return "orderItem remove of order Successfully!";
    }

    @DeleteMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public String deleteAllOrderItem(@RequestBody OrderItemDto orderItemDto) {

        OrderItemEntity orderItemEntity = orderItemMapper.dtoToEntityConvertor(orderItemDto);
        try {
            orderItemService.deleteAllOrderItem(orderItemEntity);
        } catch (Exception e) {
            return "orderItem is not found!";
        }
        return "orderItem remove of order Successfully!";
    }

    @GetMapping("/get-yeksan-nabayad-dashte-bashim")
    @PreAuthorize("hasRole('ADMIN')")
    public OrderItemDto findAllOrderItemByOrder(@RequestBody OrderDto orderDto) {
        return null;
    }



}
