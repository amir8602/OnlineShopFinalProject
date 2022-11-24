

package ir.sae.onlineshop.apis.webRestApis;

import ir.sae.onlineshop.mappers.OrderItemMapper;
import ir.sae.onlineshop.models.order.OrderModel;
import ir.sae.onlineshop.models.orderItem.OrderItemEntity;
import ir.sae.onlineshop.models.orderItem.OrderItemModel;
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
    public OrderItemModel saveOrderItem(@RequestBody OrderItemModel orderItemModel) {
        OrderItemEntity orderItemEntity = orderItemMapper.modelToEntityConvertor(orderItemModel);
        OrderItemEntity saveOrderItemEntity = orderItemService.saveOrderItem(orderItemEntity);
        OrderItemModel saveOrderItemModel = orderItemMapper.entityToModelConvertor(saveOrderItemEntity);
        return saveOrderItemModel;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public OrderItemModel getOrderItemById(@PathVariable("id") Long id) {
        OrderItemEntity orderItemEntity = new OrderItemEntity(id);
        OrderItemEntity orderItemById = orderItemService.getOrderItemById(orderItemEntity);
         OrderItemModel getOrderItemModel = orderItemMapper.entityToModelConvertor(orderItemById);
        return getOrderItemModel;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public List<OrderItemModel> getAllOrderItem() {
        List<OrderItemEntity> getAllOrderItem = orderItemService.getAll();
        List<OrderItemModel> getAllOrderItemModels = orderItemMapper.entityToModelConvertor(getAllOrderItem);
        return  getAllOrderItemModels;

    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public OrderItemModel updateOrderItem(@RequestBody OrderItemModel orderItemModel) {
        OrderItemEntity orderItemEntity = orderItemMapper.modelToEntityConvertor(orderItemModel);
        OrderItemEntity updateOrderItemEntity = orderItemService.updateOrderItem(orderItemEntity);
        OrderItemModel updateOrderItemModel = orderItemMapper.entityToModelConvertor(updateOrderItemEntity);
        return updateOrderItemModel;
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
    public String deleteAllOrderItem(@RequestBody OrderItemModel orderItemModel) {

        OrderItemEntity orderItemEntity = orderItemMapper.modelToEntityConvertor(orderItemModel);
        try {
            orderItemService.deleteAllOrderItem(orderItemEntity);
        } catch (Exception e) {
            return "orderItem is not found!";
        }
        return "orderItem remove of order Successfully!";
    }

    @GetMapping("/get-yeksan-nabayad-dashte-bashim")
    @PreAuthorize("hasRole('ADMIN')")
    public OrderItemModel findAllOrderItemByOrder(@RequestBody OrderModel orderModel) {
        return null;
    }



}
