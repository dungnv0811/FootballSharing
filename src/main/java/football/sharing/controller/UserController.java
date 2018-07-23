package football.sharing.controller;

import football.sharing.dto.user.UserDTO;
import football.sharing.service.user.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {

    public static final String BASE_URL = "/api/v1/users";
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDTO> index(){
        return userService.findAll();
    }

    @PostMapping("/register")
    public UserDTO create(@RequestBody UserDTO userDTO){
        return userService.save(userDTO);
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable(value = "id") String id){
        userService.delete(id);
        return "success";
    }

    @GetMapping(value = "/{id}")
    public UserDTO show(@PathVariable(value = "id") String id){
        return userService.findById(id);
    }

}
