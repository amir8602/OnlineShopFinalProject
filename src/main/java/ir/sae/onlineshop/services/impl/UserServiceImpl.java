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

    public UserEntity findByUsername(UserEntity userEntity) {
        return userRepository.findByUsername(userEntity.getUsername());
    }


//    @Override
//    @Transactional
//    public UserEntity saveUser(UserEntity userEntity) {
//        return userRepository.save(userEntity);
//    }
//
//    @Override
//    public List<UserEntity> getAllUser() {
//        return userRepository.findAll();
//    }
//
//    @Override
//    public UserEntity getUserById(UserEntity userEntity) {
//        return userRepository.findById(userEntity.getId()).get();
//    }
//
//    @Override
//    @Transactional
//    public UserEntity updateUser(UserEntity userEntity) {
//
//        return userRepository.save(userEntity);
//    }
//
//    @Override
//    public void deleteUser(Long id) {
//        userRepository.deleteById(id);
//
//    }


}
