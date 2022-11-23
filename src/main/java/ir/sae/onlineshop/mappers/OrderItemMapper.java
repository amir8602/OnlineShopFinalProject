package ir.sae.onlineshop.mappers;

import ir.sae.onlineshop.models.orderItem.OrderItemEntity;
import ir.sae.onlineshop.models.orderItem.OrderItemModel;

import java.util.List;

public interface OrderItemMapper {


    OrderItemEntity modelToEntityConvertor(OrderItemModel orderItemModel);

    OrderItemModel entityToModelConvertor(OrderItemEntity orderItemEntity);

    List<OrderItemEntity> modelToEntityConvertor(List<OrderItemModel> orderItemModels);

    List<OrderItemModel> entityToModelConvertor(List<OrderItemEntity> OrderItemEntity);

}