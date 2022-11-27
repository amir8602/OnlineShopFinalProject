package ir.sae.onlineshop.services;

import ir.sae.onlineshop.base.BaseService;
import ir.sae.onlineshop.entities.UserEntity;

public interface UserService extends BaseService<UserEntity, Long> {


//    UserEntity saveUser(UserEntity userEntity);
//
//    List<UserEntity> getAllUser();
//
//    UserEntity getUserById(UserEntity userEntity);
//
//    UserEntity updateUser(UserEntity userEntity);
//
//    void deleteUser(Long id);


    UserEntity findByUsername(UserEntity userEntity);
}
