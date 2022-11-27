package ir.sae.onlineshop.services.impl;

import ir.sae.onlineshop.OnlineShopApplication;
import ir.sae.onlineshop.entities.UserEntity;
import ir.sae.onlineshop.repositories.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
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
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = OnlineShopApplication.class)
@EnableTransactionManagement

class UserServiceImplTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userService;

//    @BeforeEach
//    void setUp() {
//        UserEntity userEntity = new UserEntity();
//        userEntity.setUsername("amir");
//        userEntity.setPhoneNumber("09127210123");
//        UserEntity save = userRepository.save(userEntity);
//        UserEntity userEntity1 = new UserEntity();
//        userEntity.setUsername("sara");
//        userEntity.setPhoneNumber("09127210193");
//        UserEntity save1 = userRepository.save(userEntity1);
//        UserEntity userEntity2 = new UserEntity();
//        userEntity.setUsername("erf");
//        userEntity.setPhoneNumber("43655");
//        UserEntity save2 = userRepository.save(userEntity2);
//    }


    @AfterEach
    void tearDown() {
    }

    @Test
    void getByUsername() {
        UserEntity sara = userService.getByUsername(new UserEntity("sara"));
        UserEntity sara1 = userRepository.getByUsername("sara");
        assertEquals(sara.getUsername(),sara1.getUsername());
    }

    @Test
    void save(){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("erf");
        userEntity.setPhoneNumber("6567887");
        UserEntity save = userRepository.save(userEntity);
        UserEntity userEntity1 = userRepository.findById(save.getId()).orElseThrow(RuntimeException::new);
        assertSame(save.getId(), userEntity1.getId());
    }

    @Test
    void save2(){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("wer");
        userEntity.setPhoneNumber("4356");
        UserEntity save = userRepository.save(userEntity);
        UserEntity userEntity1 = userRepository.findById(save.getId()).orElseThrow(RuntimeException::new);
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
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("amir");
        userEntity.setPhoneNumber("09127210123");
        UserEntity save = userRepository.save(userEntity);
        userService.deleteUser(1L);
        assertNull(userService.getUserById(new UserEntity(1L)).getId());
    }


}