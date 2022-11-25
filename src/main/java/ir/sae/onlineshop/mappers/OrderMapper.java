package ir.sae.onlineshop.mappers;

import ir.sae.onlineshop.base.BaseMapper;
import ir.sae.onlineshop.dto.OrderDto;
import ir.sae.onlineshop.entities.OrderEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper extends BaseMapper<OrderEntity , OrderDto> {


}
