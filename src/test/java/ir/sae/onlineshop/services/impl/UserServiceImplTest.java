package ir.sae.onlineshop.services.impl;

import ir.sae.onlineshop.OnlineShopApplication;
import ir.sae.onlineshop.entities.UserEntity;
import ir.sae.onlineshop.exceptions.BaseException;
import ir.sae.onlineshop.repositories.UserRepository;
import lombok.SneakyThrows;
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

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = OnlineShopApplication.class)
@EnableTransactionManagement
class UserServiceImplTest {

    @Autowired
    UserServiceImpl userService;
    @Autowired
    UserRepository userRepository;

    @SneakyThrows
    @BeforeEach
    void setUp() {
        UserEntity user = new UserEntity();
        user.setUsername("amir");
        UserEntity userEntity = userService.saveOrUpdate(user);
        UserEntity user1 = new UserEntity();
        user1.setUsername("erfan");
        UserEntity userEntity1 = userService.saveOrUpdate(user1);

    }

    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
    }

    @SneakyThrows
    @Test
    void findByUsername() {
        assertNotNull(userService.findAll(new UserEntity("erfan")));
    }

    @Test
    @SneakyThrows
    void save() {
        UserEntity user = new UserEntity();
        user.setUsername("ali2");
        user.setFirstName("ali");
        user.setFirstName("alavi");
        UserEntity userEntity = userService.saveOrUpdate(user);
        assertEquals(user.getUsername(),userEntity.getUsername());
    }

    @Test
    @SneakyThrows
    void update() {
        UserEntity user = new UserEntity();
        user.setUsername("taher22");
        user.setFirstName("taher");
        user.setFirstName("taheri");
        UserEntity userEntity = userService.saveOrUpdate(user);
        assertEquals(user.getUsername(),userEntity.getUsername());
    }

    @Test
    @SneakyThrows
    void findUser(){
        UserEntity user = new UserEntity();
        user.setUsername("emad");
        UserEntity userEntity = userService.saveOrUpdate(user);
        assertEquals(userService.findAll(new UserEntity(userEntity.getId())).size()
                ,userService.findAll(new UserEntity("emad")).size());
    }

    @SneakyThrows
    @Test
    void findAllSizeTest(){
        assertEquals(userRepository.findAll().size(),userService.findAll(new UserEntity()).size());
    }

    @Test
    void deleteByIdNotExist() {
        assertThrows(BaseException.class,()->userService.deleteById(12L));
    }

    @SneakyThrows
    @Test
    void deleteById(){
        assertThrows(IndexOutOfBoundsException.class,()->userService.findAll(new UserEntity(1L)).get(0));
    }


}