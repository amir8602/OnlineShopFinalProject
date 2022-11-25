package ir.sae.onlineshop.apis;


import ir.sae.onlineshop.dto.UserDto;
import ir.sae.onlineshop.entities.UserEntity;
import ir.sae.onlineshop.mappers.UserMapper;
import ir.sae.onlineshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserRestController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;


    @PostMapping
    public UserDto saveUser(@RequestBody @Valid UserDto userDto) {
        UserEntity userEntity = userMapper.modelToEntityConvertor(userDto);
        UserEntity saveUserEntity = userService.saveUser(userEntity);
        UserDto saveUserDto = userMapper.entityToModelConvertor(saveUserEntity);
        return saveUserDto;
    }

    @GetMapping
    public List<UserDto> getAllUser() {

        List<UserEntity> getAllUser = userService.getAllUser();
        List<UserDto> userDtos = userMapper.entityToModelConvertor(getAllUser);
        return userDtos;


    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable("id") Long id) {
        UserEntity userEntity = new UserEntity(id);
        UserEntity getUserById = userService.getUserById(userEntity);
        UserDto userDto = userMapper.entityToModelConvertor(getUserById);
        return userDto;
    }


    @PutMapping
    public UserDto updateUser(@RequestBody UserDto userDto) {
        UserEntity userEntity = userMapper.modelToEntityConvertor(userDto);
        UserEntity user = new UserEntity(userDto.getId());
        UserEntity userById = userService.getUserById(user);
        userEntity.setVersion(userById.getVersion());
        userEntity.setCreateDate(userById.getCreateDate());
        UserEntity saveUserEntity = userService.updateUser(userEntity);
        UserDto saveUserDto = userMapper.entityToModelConvertor(saveUserEntity);
        return saveUserDto;
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

    @GetMapping("/{username}")
    public UserDto getUserByUsername(@PathVariable("username") String username){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        UserEntity find=userService.getByUsername(userEntity);
        UserDto userDto = userMapper.entityToModelConvertor(find);
        return userDto;
    }

}
