package org.inadvance.service;

import org.inadvance.dto.UserRequestDTO;
import org.inadvance.dto.UserResponseDTO;

import java.util.List;

public interface UserService {
    UserResponseDTO registerUser(UserRequestDTO newUser);
    List<UserResponseDTO> getListUser();
}
