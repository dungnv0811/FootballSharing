package football.sharing.dto.user;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.Email;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@EqualsAndHashCode
public class UserDTO {

    String id;

    @Email
    String email;

    String username;

    String password;

    String name;

    String firstName;

    String lastName;

    String country;

    String city;

    String bio;

    String avatarUrl;

    String coverUrl;

    LocalDateTime updatedAt;

    LocalDateTime createdAt;


}