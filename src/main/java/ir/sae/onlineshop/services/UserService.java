package ir.sae.onlineshop.services;

import ir.sae.onlineshop.base.BaseService;
import ir.sae.onlineshop.entities.UserEntity;

public interface UserService extends BaseService<UserEntity, Long> {

    UserEntity findByUsername(UserEntity userEntity);
}
