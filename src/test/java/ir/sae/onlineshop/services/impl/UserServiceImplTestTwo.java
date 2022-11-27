package ir.sae.onlineshop.services.impl;

import ir.sae.onlineshop.OnlineShopApplication;
import ir.sae.onlineshop.entities.UserEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.List;

import static org.junit.Assert.assertSame;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = OnlineShopApplication.class)
@EnableTransactionManagement

class UserServiceImplTestTwo {



    @Autowired
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("amir");
        userEntity.setPhoneNumber("09127210123");
        UserEntity save = userService.saveUser(userEntity);
        UserEntity userEntity1 = new UserEntity();
        userEntity.setUsername("sara");
        userEntity.setPhoneNumber("09127210193");
        UserEntity save1 = userService.saveUser(userEntity1);
        UserEntity userEntity2 = new UserEntity();
        userEntity.setUsername("erf");
        userEntity.setPhoneNumber("43655");
        UserEntity save2 = userService.saveUser(userEntity2);
    }


    @AfterEach
    void tearDown() {
    }

    @Test
    void getByUsername() {
        UserEntity userEntity1 = new UserEntity();
        userEntity1.setUsername("sara");
        userEntity1.setPhoneNumber("09127210193");
        UserEntity save1 = userService.saveUser(userEntity1);
        UserEntity sara = userService.getByUsername(new UserEntity("sara"));
        UserEntity sara1 = userService.getByUsername(new UserEntity("sara"));
        assertEquals(sara.getUsername(),sara1.getUsername());
    }

    @Test
    void save(){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("erf");
        userEntity.setPhoneNumber("6567887");
        UserEntity save = userService.saveUser(userEntity);
        UserEntity userEntity1 = userService.getUserById(save);
        assertSame(save.getId(), userEntity1.getId());
    }

    @Test
    void save2(){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("wer");
        userEntity.setPhoneNumber("4356");
        UserEntity save = userService.saveUser(userEntity);
        UserEntity userEntity1 = userService.getUserById(save);
        assertNull(save.getEmail());
    }

    @Test
    void getAllUser(){
        List<UserEntity> allUser = userService.getAllUser();

        List<UserEntity> all = userService.getAllUser();

        assertEquals(allUser.get(0).toString(),all.get(0).toString());
    }
    @Test
    void update(){
        UserEntity userEntity = userService.getUserById(new UserEntity(1L));
        userEntity.setUsername("432");
        UserEntity userEntity1 = userService.updateUser(userEntity);
        assertEquals("432",userEntity1.getUsername());
    }
    @Test
    void delete(){
        userService.deleteUser(2L);
        assertNull(userService.getUserById(new UserEntity(2L)).getFirstName());
    }


}