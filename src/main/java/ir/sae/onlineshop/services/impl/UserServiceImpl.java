package ir.sae.onlineshop.services.impl;

import ir.sae.onlineshop.base.BaseServiceImpl;
import ir.sae.onlineshop.entities.UserEntity;
import ir.sae.onlineshop.repositories.UserRepository;
import ir.sae.onlineshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl extends BaseServiceImpl<UserEntity,
        Long, UserRepository> implements UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional
    public UserEntity findByUsername(UserEntity userEntity) {
        return userRepository.findByUsername(userEntity.getUsername());
    }

}
