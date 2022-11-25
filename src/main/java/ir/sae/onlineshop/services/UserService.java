package ir.sae.onlineshop.services;

import ir.sae.onlineshop.entities.UserEntity;

public interface UserService {



    UserEntity getByUsername(UserEntity userEntity);
}
