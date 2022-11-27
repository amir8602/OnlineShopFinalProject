package ir.sae.onlineshop.base;

import ir.sae.onlineshop.OnlineShopApplication;
import ir.sae.onlineshop.entities.UserEntity;
import ir.sae.onlineshop.repositories.UserRepository;
import ir.sae.onlineshop.services.impl.UserServiceImpl;
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

import static org.junit.Assert.assertSame;

@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = OnlineShopApplication.class)
@EnableTransactionManagement
class BaseServiceImplTest {






    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {



    }

//    @Test
//    void getById() {
//
//        UserEntity userEntity = new UserEntity();
//        userEntity.setId(1L);
//        UserEntity save = userService.save(userEntity);
//        userService.getById(1L);
//
//
//    }

    @Test
    void getAll() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void searchByExample() {
    }
}