package football.sharing.mapper.user;

import football.sharing.domain.User;
import football.sharing.dto.user.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "password", ignore = true)
    UserDTO userToUserDTO(User user);

    User userDtoToUser(UserDTO userDTO);
}
