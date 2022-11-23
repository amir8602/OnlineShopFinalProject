package ir.sae.onlineshop.mappers;

import ir.sae.onlineshop.models.order.OrderEntity;
import ir.sae.onlineshop.models.order.OrderModel;

import java.util.List;

public interface OrderMapper {


    OrderEntity modelToEntityConvertor(OrderModel orderModel);

    OrderModel entityToModelConvertor(OrderEntity orderEntity);

    List<OrderEntity> modelToEntityConvertor(List<OrderModel> orderModels);

    List<OrderModel> entityToModelConvertor(List<OrderEntity> orderEntities);

}
