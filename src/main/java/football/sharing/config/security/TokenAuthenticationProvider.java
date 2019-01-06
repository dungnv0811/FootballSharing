package football.sharing.config.security;

import football.sharing.service.api.UserAuthenticationService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
final class TokenAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
    @NonNull
    private UserAuthenticationService auth;

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken auth) {
        // Nothing to do
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) {
        final Object token = authentication.getCredentials();
        return Optional
            .ofNullable(token)
            .map(String::valueOf)
            .flatMap(auth::findByToken)
            .orElseThrow(() -> new UsernameNotFoundException("Cannot find user with authentication token=" + token));
    }
}