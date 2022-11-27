package ir.sae.onlineshop.apis;


import ir.sae.onlineshop.configs.security.controllers.AuthController;
import ir.sae.onlineshop.configs.security.payload.request.SignupRequest;
import ir.sae.onlineshop.dto.UserDto;
import ir.sae.onlineshop.entities.UserEntity;
import ir.sae.onlineshop.exceptions.BaseException;
import ir.sae.onlineshop.mappers.UserMapper;
import ir.sae.onlineshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @Autowired
    private AuthController authController;





    @PostMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public UserDto saveUser(@RequestBody @Valid UserDto userDto) {
        SignupRequest signupRequest = new SignupRequest();
        signupRequest.setEmail(userDto.getEmail());
        signupRequest.setUsername(userDto.getUsername());
        signupRequest.setPassword(userDto.getPassword());
        UserEntity userEntity = userMapper.dtoToEntityConvertor(userDto);
        authController.registerUser(signupRequest);
        UserEntity saveUserEntity = userService.saveUser(userEntity);
        UserDto saveUserDto = userMapper.entityToDtoConvertor(saveUserEntity);
        return saveUserDto;
    }

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public List<UserDto> getAllUser() {
        List<UserEntity> getAllUser = userService.getAllUser();
        List<UserDto> userDtos = userMapper.entityToDtoConvertor(getAllUser);
        return userDtos;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public UserDto getUserById(@PathVariable("id") Long id) throws BaseException {
        UserEntity userEntity = new UserEntity(id);
        UserEntity getUserById = userService.getUserById(userEntity);
        UserDto userDto = userMapper.entityToDtoConvertor(getUserById);
        return userDto;
    }


    @PutMapping
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        UserEntity userEntity = userMapper.dtoToEntityConvertor(userDto);
        UserEntity saveUserEntity = userService.updateUser(userEntity);
        return userMapper.entityToDtoConvertor(saveUserEntity);
    }


    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public String deleteUserById(@PathVariable("id") Long id) {
        UserEntity userEntity = new UserEntity(id);
        try {

            userService.deleteUser(userEntity.getId());
        } catch (Exception e) {
            return "user is not found!";
        }
        return "user remove Successfully!";
    }

    @GetMapping("/byUserName/{username}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public UserDto getUserByUsername(@PathVariable("username") String username) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        UserEntity find = userService.getByUsername(userEntity);
        UserDto userDto = userMapper.entityToDtoConvertor(find);
        return userDto;
    }

}
