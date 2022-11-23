package ir.sae.onlineshop.mappers;


import ir.sae.onlineshop.models.product.ProductEntity;
import ir.sae.onlineshop.models.product.ProductModel;
import org.mapstruct.Mapper;

import java.util.List;


@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductEntity modelToEntityConvertor(ProductModel productModel);

    ProductModel entityToModelConvertor(ProductEntity productEntity);

    List<ProductEntity> modelToEntityConvertor(List<ProductModel> productModel);

    List<ProductModel> entityToModelConvertor(List<ProductEntity> productEntity);

}
