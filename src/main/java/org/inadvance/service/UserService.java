package org.inadvance.service;

import org.inadvance.dto.UserDTO;
import org.inadvance.model.User;

import java.util.List;

public interface UserService {
    UserDTO registerUser(User newUser);
    List<UserDTO> getListUser();
}
