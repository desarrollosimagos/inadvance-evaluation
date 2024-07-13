package org.inadvance.service.mapper;

import org.inadvance.dto.UserDTO;
import org.inadvance.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO userToUserDTO(User user);

    @Mapping(target = "created", ignore = true)
    @Mapping(target = "modified", ignore = true)
    @Mapping(target = "lastLogin", ignore = true)
    @Mapping(target = "token", ignore = true)
    @Mapping(target = "active", ignore = true)
    User userDTOToUser(UserDTO userDTO);

    List<UserDTO> usersToUserDTOs(List<User> users);

}