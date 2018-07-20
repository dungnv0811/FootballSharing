package football.sharing.security;

import football.sharing.repository.user.UserRepository;
import football.sharing.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FootballUserDetailsService implements UserDetailsService {
    private final UserRepository repository;

    @Autowired
    public FootballUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = repository.findByUsername(username);
        if(!user.isPresent()) {
            throw new UsernameNotFoundException("User not found");
        }
        return user.get();
    }
}
