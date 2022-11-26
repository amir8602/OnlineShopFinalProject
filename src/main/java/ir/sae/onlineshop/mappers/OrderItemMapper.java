package ir.sae.onlineshop.mappers;

import ir.sae.onlineshop.base.BaseMapper;
import ir.sae.onlineshop.dto.OrderItemDto;
import ir.sae.onlineshop.entities.OrderItemEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderItemMapper extends BaseMapper<OrderItemEntity , OrderItemDto> {
}
