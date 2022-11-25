package ir.sae.onlineshop.mappers;

import ir.sae.onlineshop.base.BaseMapper;
import ir.sae.onlineshop.dto.ProductDto;
import ir.sae.onlineshop.entities.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper extends BaseMapper<ProductEntity , ProductDto> {



}
