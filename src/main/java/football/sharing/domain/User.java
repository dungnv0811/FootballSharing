package football.sharing.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.Email;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;

@Document(collection = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {

    @Id
    private String id;
    private String username;
    private String password;
    private Set<Role> roles;
    private boolean accountNonExpired = true;

    private boolean accountNonLocked = true;

    private boolean enabled = true;

    private boolean credentialsNonExpired = true;

    @Email
    private String email;

    private String name;

    private String firstName;

    private String lastName;

    private String country;

    private String city;

    private String bio;

    private String avatarUrl;

    private String coverUrl;

    private String facebookId;

    private String googleId;

    private String resetPasswordToken;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }

}