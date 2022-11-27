package ir.sae.onlineshop.services;

import ir.sae.onlineshop.entities.UserEntity;
import ir.sae.onlineshop.exceptions.BaseException;

import java.util.List;

public interface UserService {


     UserEntity saveUser(UserEntity userEntity)throws BaseException;

    List<UserEntity> getAllUser()throws BaseException;

    UserEntity getUserById(UserEntity userEntity) throws BaseException;

    UserEntity updateUser(UserEntity userEntity) throws BaseException;

    void deleteUser(Long id) throws BaseException;

    UserEntity getByUsername(UserEntity userEntity) throws BaseException;
}
