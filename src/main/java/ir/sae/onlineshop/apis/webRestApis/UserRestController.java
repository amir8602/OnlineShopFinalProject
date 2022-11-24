package ir.sae.onlineshop.apis.webRestApis;


import ir.sae.onlineshop.mappers.UserMapper;
import ir.sae.onlineshop.models.user.UserEntity;
import ir.sae.onlineshop.models.user.UserModel;
import ir.sae.onlineshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;


    @PostMapping
    public UserModel saveUser(@RequestBody UserModel userModel) {
        UserEntity userEntity = userMapper.modelToEntityConvertor(userModel);
        UserEntity saveUserEntity = userService.saveUser(userEntity);
        UserModel saveUserModel = userMapper.entityToModelConvertor(saveUserEntity);
        return saveUserModel;

    }

    @GetMapping
    public List<UserModel> getAllUser() {

        List<UserEntity> getAllUser = userService.getAllUser();
        List<UserModel> userModels = userMapper.entityToModelConvertor(getAllUser);
        return userModels;


    }

    @GetMapping("/{id}")
    public UserModel getUserById(@PathVariable("id") Long id) {
        UserEntity userEntity = new UserEntity(id);
        UserEntity getUserById = userService.getUserById(userEntity);
        UserModel userModel = userMapper.entityToModelConvertor(getUserById);
        return userModel;


    }


    @PutMapping
    public UserModel updateUser(@RequestBody UserModel userModel) {
        UserEntity userEntity = userMapper.modelToEntityConvertor(userModel);
        UserEntity saveUserEntity = userService.updateUser(userEntity);
        UserModel saveUserModel = userMapper.entityToModelConvertor(saveUserEntity);
        return saveUserModel;

    }


    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable("id") Long id) {
        UserEntity userEntity = new UserEntity(id);
        try {

            userService.deleteUser(userEntity.getId());
        } catch (Exception e) {
            return "user is not found!";
        }
        return "user remove Successfully!";
    }

    @GetMapping("/get-user-by-username/{username}")
    public UserModel getUserByUsername(@PathVariable("username") String username){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        UserEntity find=userService.getByUsername(userEntity);
        UserModel userModel = userMapper.entityToModelConvertor(find);
        return userModel;
    }

}
