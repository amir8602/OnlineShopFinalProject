package ir.sae.onlineshop.services;

import ir.sae.onlineshop.entities.UserEntity;
import ir.sae.onlineshop.exceptions.BaseException;

import java.util.List;

public interface UserService {


    UserEntity saveUser(UserEntity userEntity);

    List<UserEntity> getAllUser();

    UserEntity getUserById(UserEntity userEntity) throws BaseException;

    UserEntity updateUser(UserEntity userEntity);

    void deleteUser(Long id);


    UserEntity getByUsername(UserEntity userEntity);
}
