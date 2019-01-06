package football.sharing.service.api;

import football.sharing.model.User;

import java.util.Optional;

public interface UserService {
    User save(User user);

    Optional<User> findById(String id);

    Optional<User> findByUsername(String username);
}
