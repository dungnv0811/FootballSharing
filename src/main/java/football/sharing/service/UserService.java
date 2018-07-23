package football.sharing.service;

import football.sharing.domain.User;

import java.util.List;

public interface UserService {
    User save(User user);
    List<User> findAll();
    void delete(String id);
}
