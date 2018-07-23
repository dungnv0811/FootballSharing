package football.sharing.service.user;

import football.sharing.domain.User;
import football.sharing.dto.user.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO save(UserDTO userDTO);
    List<User> findAll();
    void delete(String id);
}
