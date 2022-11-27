package ir.sae.onlineshop.services.impl;

import ir.sae.onlineshop.OnlineShopApplication;
import ir.sae.onlineshop.entities.UserEntity;
import ir.sae.onlineshop.enums.UserStatus;
import ir.sae.onlineshop.repositories.UserRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Date;


@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = OnlineShopApplication.class)
//@ContextConfiguration(classes=OnlineShopApplication.class)
@EnableTransactionManagement
//@DataJpaTest
class UserServiceImplTest {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private TestEntityManager testEntityManager;



//    @DisplayName("")
    @BeforeEach
    void setUp() {
//        testEntityManager.persist()
    }

//    @DisplayName("")
    @AfterEach
    void tearDown() {
    }



    @DisplayName("user-save")
    @Test
    void saveUser() {
        UserEntity user = new UserEntity();
        user.setUsername("amir");
        user.setPhoneNumber("09127210835");
        user.setFirstName("amir");
        user.setLastName("ghaderi");
        user.setNationalCode("0023202904");
        user.setBirthDate(new Date());
        user.setEmail("a.a@gmail.com");
        user.setStatus(UserStatus.ACTIVE);
        testEntityManager.persist(user);
//        UserEntity save = userService.saveUser(user);
        UserEntity user1 = userService.getUserById(user);
        Assertions.assertEquals(2,2);
    }




//    @DisplayName("")
    @Test
    void getAllUser() {
    }

//    @DisplayName("")
    @Test
    void getUserById() {
    }

//    @DisplayName("")
    @Test
    void updateUser() {
    }

//    @DisplayName("")
    @Test
    void deleteUser() {
    }

//    @DisplayName("")
    @Test
    void getByUsername() {
    }
}