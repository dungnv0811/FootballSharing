package football.sharing.service.user;

import football.sharing.domain.Role;
import football.sharing.domain.User;
import football.sharing.dto.user.UserDTO;
import football.sharing.exception.FootballNotFoundException;
import football.sharing.mapper.user.UserMapper;
import football.sharing.repository.user.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service(value = "userService")
public class UserServiceImpl implements  UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO save(UserDTO userDTO) {
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        User user = userMapper.userDtoToUser(userDTO);
        user.setRoles(getDefaultRole());
        user.setCreatedAt(LocalDateTime.now());
        return userMapper.userToUserDTO(userRepository.save(user));
    }

    public List findAll() {
        List<UserDTO> list = userRepository.findAll().stream().map(userMapper::userToUserDTO).collect(Collectors.toList());
        return list;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public UserDTO findById(String id) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new FootballNotFoundException("Can not find user");
        }
        return userMapper.userToUserDTO(user.get());
    }

    private Set<Role> getDefaultRole() {
        Role role = new Role();
        role.setAuthority("USER");
        return new HashSet<>(Arrays.asList(role));
    }
}
