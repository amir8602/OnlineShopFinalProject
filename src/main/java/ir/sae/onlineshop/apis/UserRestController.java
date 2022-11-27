package ir.sae.onlineshop.apis;


import ir.sae.onlineshop.base.BaseRestController;
import ir.sae.onlineshop.dto.UserDto;
import ir.sae.onlineshop.entities.UserEntity;
import ir.sae.onlineshop.mappers.UserMapper;
import ir.sae.onlineshop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserRestController extends BaseRestController<
        UserDto, UserEntity, UserMapper, UserService, Long> {



    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    public UserRestController(UserService service, UserMapper mapper) {
        super(service, mapper);
    }

    @GetMapping("/{username}")
    public UserDto getUserByUsername(@PathVariable("username") String username){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        UserEntity find=userService.findByUsername(userEntity);
        UserDto userDto = userMapper.entityToDtoConvertor(find);
        return userDto;
    }

//        @PostMapping
//    public UserDto saveUser(@RequestBody @Valid UserDto userDto) {
//        UserEntity userEntity = userMapper.dtoToEntityConvertor(userDto);
//        UserEntity saveUserEntity = userService.saveUser(userEntity);
//        UserDto saveUserDto = userMapper.entityToDtoConvertor(saveUserEntity);
//        return saveUserDto;
//    }
//
//    @GetMapping
//    public List<UserDto> getAllUser() {
//
//        List<UserEntity> getAllUser = userService.getAllUser();
//        List<UserDto> userDtos = userMapper.entityToDtoConvertor(getAllUser);
//        return userDtos;
//
//
//    }
//
//    @GetMapping("/{id}")
//    public UserDto getUserById(@PathVariable("id") Long id) {
//        UserEntity userEntity = new UserEntity(id);
//        UserEntity getUserById = userService.getUserById(userEntity);
//        UserDto userDto = userMapper.entityToDtoConvertor(getUserById);
//        return userDto;
//    }
//
//
//    @PutMapping
//    public UserDto updateUser(@RequestBody UserDto userDto) {
//        UserEntity userEntity = userMapper.dtoToEntityConvertor(userDto);
//        UserEntity user = new UserEntity(userDto.getId());
//        UserEntity userById = userService.getUserById(user);
//        userEntity.setVersion(userById.getVersion());
//        userEntity.setCreateDate(userById.getCreateDate());
//        UserEntity saveUserEntity = userService.updateUser(userEntity);
//        UserDto saveUserDto = userMapper.entityToDtoConvertor(saveUserEntity);
//        return saveUserDto;
//    }
//
//
//    @DeleteMapping("/{id}")
//    public void deleteUserById(@PathVariable("id") Long id) {
//        UserEntity userEntity = new UserEntity(id);
//
//
//        userService.deleteUser(userEntity.getId());
//    }


}
