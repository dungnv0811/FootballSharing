package football.sharing.service.user;

import football.sharing.dto.user.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO save(UserDTO userDTO);
    List<UserDTO> findAll();
    void delete(String id);
    UserDTO findById(String id);
}
