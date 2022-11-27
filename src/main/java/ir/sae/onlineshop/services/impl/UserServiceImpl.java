package ir.sae.onlineshop.services.impl;

import ir.sae.onlineshop.entities.UserEntity;
import ir.sae.onlineshop.exceptions.BaseException;
import ir.sae.onlineshop.repositories.UserRepository;
import ir.sae.onlineshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService{


    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserEntity saveUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public List<UserEntity> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getUserById(UserEntity userEntity)throws BaseException {
        UserEntity user;
        try {
             user = userRepository.findById(userEntity.getId()).get();
        }catch (NoSuchElementException e){
            //Log
            throw new BaseException("Entity not found" , e.getCause() , "NoSuchElementException"  );
        }
        return user;
    }

    @Override
    @Transactional
    public UserEntity updateUser(UserEntity userEntity) {
        return userRepository.save(userEntity);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);

    }

    @Override
    public UserEntity getByUsername(UserEntity userEntity) {
        return userRepository.getByUsername(userEntity.getUsername());
    }
}
