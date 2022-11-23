package ir.sae.onlineshop.mappers;

import ir.sae.onlineshop.models.user.UserEntity;
import ir.sae.onlineshop.models.user.UserModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {



    UserModel entityToModelConvertor(UserEntity userEntity);

    UserEntity modelToEntityConvertor(UserModel userModel);

    List<UserModel> entityToModelConvertor(List<UserEntity> userEntity);

    List<UserEntity> modelToEntityConvertor(List<UserModel> userModels);
}
