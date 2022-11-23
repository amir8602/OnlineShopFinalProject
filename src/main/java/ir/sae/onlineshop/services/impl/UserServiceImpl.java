package ir.sae.onlineshop.services.impl;

import ir.sae.onlineshop.models.user.UserEntity;
import ir.sae.onlineshop.models.user.dao.UserDao;
import ir.sae.onlineshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{


    @Autowired
    UserDao userDao;

    @Override
    public UserEntity saveUser(UserEntity userEntity) {
        return userDao.save(userEntity);
    }

    @Override
    public List<UserEntity> getAllUser() {
        return userDao.findAll();
    }

    @Override
    public UserEntity getUserById(UserEntity userEntity) {
        return userDao.findById(userEntity.getId()).get();
    }

    @Override
    public UserEntity updateUser(UserEntity userEntity) {
        return userDao.save(userEntity);
    }

    @Override
    public void deleteUser(Long id) {
        userDao.deleteById(id);

    }
}
