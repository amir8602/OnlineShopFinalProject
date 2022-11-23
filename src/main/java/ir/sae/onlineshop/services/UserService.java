package ir.sae.onlineshop.services;

import ir.sae.onlineshop.models.user.UserEntity;

import java.util.List;

public interface UserService {


    UserEntity saveUser(UserEntity userEntity);

    List<UserEntity> getAllUser();

    UserEntity getUserById(UserEntity userEntity);

    UserEntity updateUser(UserEntity userEntity);

    void deleteUser(Long id);


}
