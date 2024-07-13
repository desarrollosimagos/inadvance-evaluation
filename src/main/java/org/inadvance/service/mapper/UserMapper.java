package org.inadvance.service.mapper;

import org.inadvance.dto.UserRequestDTO;
import org.inadvance.dto.UserResponseDTO;
import org.inadvance.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserResponseDTO userToUserDTO(User user);

    User userRequestDTOToUser(UserRequestDTO user);

    @Mapping(target = "created", ignore = true)
    @Mapping(target = "modified", ignore = true)
    @Mapping(target = "lastLogin", ignore = true)
    @Mapping(target = "token", ignore = true)
    @Mapping(target = "active", ignore = true)
    User userDTOToUser(UserResponseDTO userResponseDTO);

    List<UserResponseDTO> usersToUserDTOs(List<User> users);

}