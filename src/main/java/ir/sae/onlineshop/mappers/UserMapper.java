package ir.sae.onlineshop.mappers;

import ir.sae.onlineshop.base.BaseMapper;
import ir.sae.onlineshop.dto.UserDto;
import ir.sae.onlineshop.entities.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<UserEntity , UserDto> {

}
