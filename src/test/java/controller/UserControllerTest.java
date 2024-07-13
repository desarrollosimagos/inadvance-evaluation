package controller;

import org.inadvance.controller.UserController;
import org.inadvance.dto.UserRequestDTO;
import org.inadvance.dto.UserResponseDTO;
import org.inadvance.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreateUserSuccess() {
        UserRequestDTO userRequestDTO = new UserRequestDTO();
        userRequestDTO.setName("Juan Rodriguez");
        userRequestDTO.setEmail("juan@rodriguez.org");
        userRequestDTO.setPassword("SecurePassword123");

        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(UUID.randomUUID());
        userResponseDTO.setCreated(LocalDateTime.now());
        userResponseDTO.setModified(LocalDateTime.now());
        userResponseDTO.setLastLogin(null);
        userResponseDTO.setActive(Boolean.TRUE);

        when(userService.registerUser(any(UserRequestDTO.class))).thenReturn(userResponseDTO);

        ResponseEntity<?> responseEntity = userController.createUser(userRequestDTO);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(userResponseDTO, responseEntity.getBody());
    }

    @Test
    void testCreateUserFailure() {
        UserRequestDTO userRequestDTO = new UserRequestDTO();
        userRequestDTO.setName("Juan Rodriguez");
        userRequestDTO.setEmail("juan@rodriguez.org");
        userRequestDTO.setPassword("SecurePassword123");

        when(userService.registerUser(any(UserRequestDTO.class))).thenThrow(new IllegalArgumentException("Email already registered."));

        ResponseEntity<?> responseEntity = userController.createUser(userRequestDTO);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("Email already registered.", ((HashMap) responseEntity.getBody()).get("message"));
    }

    @Test
    void testGetListUserSuccess() {
        List<UserResponseDTO> userList = new ArrayList<>();
        UserResponseDTO user1 = new UserResponseDTO();
        user1.setId(UUID.randomUUID());
        user1.setCreated(LocalDateTime.now());
        user1.setModified(LocalDateTime.now());
        user1.setLastLogin(null);
        user1.setActive(Boolean.TRUE);

        UserResponseDTO user2 = new UserResponseDTO();
        user2.setId(UUID.randomUUID());
        user2.setCreated(LocalDateTime.now());
        user2.setModified(LocalDateTime.now());
        user2.setLastLogin(null);
        user2.setActive(Boolean.TRUE);

        userList.add(user1);
        userList.add(user2);

        when(userService.getListUser()).thenReturn(userList);

        ResponseEntity<?> responseEntity = userController.getListUser();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(userList, responseEntity.getBody());
    }

    @Test
    void testGetListUserFailure() {
        when(userService.getListUser()).thenThrow(new IllegalArgumentException("No users found."));

        ResponseEntity<?> responseEntity = userController.getListUser();

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertEquals("No users found.", ((HashMap) responseEntity.getBody()).get("message"));
    }
}