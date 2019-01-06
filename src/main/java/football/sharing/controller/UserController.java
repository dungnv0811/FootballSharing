package football.sharing.controller;

import football.sharing.model.User;
import football.sharing.service.api.UserAuthenticationService;
import football.sharing.service.api.UserService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping("/users")
@FieldDefaults(level = PRIVATE, makeFinal = true)
@AllArgsConstructor(access = PACKAGE)
class UserController {
    @NonNull
    UserService userService;
    @NonNull
    UserAuthenticationService userAuthenticationService;

    @PostMapping("/register")
    public String register(
        @RequestParam("username") final String username,
        @RequestParam("password") final String password) {
        User user = User.builder().id(username).username(username).password(password).build();
        userService.save(user);

        return login(username, password);
    }

    @PostMapping("/login")
    public String login(
        @RequestParam("username") final String username,
        @RequestParam("password") final String password) {
        return userAuthenticationService
            .login(username, password)
            .orElseThrow(() -> new RuntimeException("invalid login and/or password"));
    }

    @GetMapping("/current")
    public User getCurrentUser(@AuthenticationPrincipal User user) {
        return user;
    }

    @GetMapping("/logout")
    public boolean logout(@AuthenticationPrincipal User user) {
        userAuthenticationService.logout(user);
        return true;
    }
}
