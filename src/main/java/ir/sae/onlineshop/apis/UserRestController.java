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
        return userMapper.entityToDtoConvertor(find);
    }

}
