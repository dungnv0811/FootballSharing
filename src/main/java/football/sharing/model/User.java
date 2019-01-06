package football.sharing.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

import static java.util.Objects.requireNonNull;

@Builder
@Value
public class User implements UserDetails {
    private static final long serialVersionUID = 2396654715019746670L;

    private String id;
    private String username;
    private String password;

    @JsonCreator
    User(@JsonProperty("id") String id,
         @JsonProperty("username") String username,
         @JsonProperty("password") String password) {
        super();
        this.id = requireNonNull(id);
        this.username = requireNonNull(username);
        this.password = requireNonNull(password);
    }

    @JsonIgnore
    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @JsonIgnore
    @Override
    public String getUsername() {
        return username;
    }

    @JsonIgnore
    public String getId() {
        return id;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}

