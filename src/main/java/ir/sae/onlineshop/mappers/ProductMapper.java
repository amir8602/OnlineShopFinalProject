package ir.sae.onlineshop.mappers;

import ir.sae.onlineshop.models.product.ProductEntity;
import ir.sae.onlineshop.models.product.ProductModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductEntity modelToEntity(ProductModel productModel);
    ProductModel entityToModel(ProductEntity productEntity);

    List<ProductEntity> modelListToEntityList(List<ProductModel> productModels);
    List<ProductModel> entityListToModelList(List<ProductEntity> productEntities);

}
