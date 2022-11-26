package ir.sae.onlineshop.base;

import ir.sae.onlineshop.OnlineShopApplication;
import ir.sae.onlineshop.entities.UserEntity;
import ir.sae.onlineshop.repositories.UserRepository;
import ir.sae.onlineshop.services.impl.UserServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
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



    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userService;


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("sara");
        userEntity.setPhoneNumber("09127210835");
        UserEntity save = userRepository.save(userEntity);
        UserEntity userEntity1 = userRepository.findById(save.getId()).orElseThrow(RuntimeException::new);
        assertSame(save.getId(), userEntity1.getId());

    }

    @Test
    void getById() {

        UserEntity userEntity = new UserEntity();
        UserEntity save = userService.saveUser(userEntity);
        UserEntity userById = userService.getUserById(save);
        Assertions.assertNotNull(userById.getId());
    }
    @Test
    void getById2() {
        Assertions.assertThrows(NullPointerException.class,() -> userService.getUserById(null));
  }

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