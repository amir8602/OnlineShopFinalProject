package ir.sae.onlineshop.mappers;

import ir.sae.onlineshop.models.order.OrderEntity;
import ir.sae.onlineshop.models.order.OrderModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderModel entityToModelConvertor(OrderEntity orderEntity);

    OrderEntity modelToEntityConvertor(OrderModel orderModel);

    List<OrderModel> entityToModelConvertor(List<OrderEntity> orderEntities);

    List<OrderEntity> modelToEntityConvertor(List<OrderModel> orderModels);

}
