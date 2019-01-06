package football.sharing.service.implementation;

import com.google.common.collect.ImmutableMap;
import football.sharing.model.User;
import football.sharing.service.api.TokenService;
import football.sharing.service.api.UserAuthenticationService;
import football.sharing.service.api.UserService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@Service
@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = PRIVATE, makeFinal = true)
final class TokenUserAuthenticationService implements UserAuthenticationService {
    @NonNull
    TokenService tokenService;
    @NonNull
    UserService userService;

    @Override
    public Optional<String> login(final String username, final String password) {
        return userService
            .findByUsername(username)
            .filter(user -> Objects.equals(password, user.getPassword()))
            .map(user -> tokenService.expiring(ImmutableMap.of("username", username)));
    }

    @Override
    public Optional<User> findByToken(final String token) {
        return Optional
            .of(tokenService.verify(token))
            .map(map -> map.get("username"))
            .flatMap(userService::findByUsername);
    }

    @Override
    public void logout(final User user) {
        // Nothing to doy
    }
}
