package service;

import org.inadvance.dto.UserRequestDTO;
import org.inadvance.dto.UserResponseDTO;
import org.inadvance.model.User;
import org.inadvance.repository.UserRepository;
import org.inadvance.service.impl.UserServiceImpl;
import org.inadvance.service.mapper.UserMapper;
import org.inadvance.util.JwtUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.env.Environment;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private JwtUtil jwtUtil;

    @Mock
    private Environment env;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        when(env.getProperty("user.email.regex")).thenReturn("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        when(env.getProperty("user.password.regex")).thenReturn("^(?=.*[A-Z])(?=.*\\d).{8,}$");
    }

    @Test
    void testRegisterUserSuccess() {
        UserRequestDTO userRequestDTO = new UserRequestDTO();
        userRequestDTO.setName("Juan Rodriguez");
        userRequestDTO.setEmail("juan@rodriguez.org");
        userRequestDTO.setPassword("SecurePassword123");

        User user = UserMapper.INSTANCE.userRequestDTOToUser(userRequestDTO);
        User savedUser = user;
        savedUser.setId(UUID.randomUUID());

        when(jwtUtil.generateToken(any(User.class))).thenReturn("token");
        when(userRepository.existsByEmail(any(String.class))).thenReturn(false);
        when(userRepository.save(any(User.class))).thenReturn(savedUser);

        UserResponseDTO userResponseDTO = userService.registerUser(userRequestDTO);

        assertEquals(user.getId(), userResponseDTO.getId());
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void testRegisterUserEmailAlreadyRegistered() {
        UserRequestDTO userRequestDTO = new UserRequestDTO();
        userRequestDTO.setName("Juan Rodriguez");
        userRequestDTO.setEmail("juan@rodriguez.org");
        userRequestDTO.setPassword("SecurePassword123");

        when(userRepository.existsByEmail(any(String.class))).thenReturn(true);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            userService.registerUser(userRequestDTO);
        });

        assertEquals("Email already registered.", exception.getMessage());
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    void testRegisterUserInvalidEmailFormat() {
        UserRequestDTO userRequestDTO = new UserRequestDTO();
        userRequestDTO.setName("Juan Rodriguez");
        userRequestDTO.setEmail("juan@rodriguez");
        userRequestDTO.setPassword("SecurePassword123");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            userService.registerUser(userRequestDTO);
        });

        assertEquals("Invalid email format", exception.getMessage());
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    void testRegisterUserInvalidPasswordFormat() {
        UserRequestDTO userRequestDTO = new UserRequestDTO();
        userRequestDTO.setName("Juan Rodriguez");
        userRequestDTO.setEmail("juan@rodriguez.org");
        userRequestDTO.setPassword("password");

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            userService.registerUser(userRequestDTO);
        });

        assertEquals("Invalid password format", exception.getMessage());
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    void testGetListUserSuccess() {
        User user1 = new User();
        user1.setId(UUID.randomUUID());
        user1.setName("Juan Rodriguez");
        user1.setEmail("juan@rodriguez.org");

        User user2 = new User();
        user2.setId(UUID.randomUUID());
        user2.setName("Maria Gomez");
        user2.setEmail("maria@gomez.org");

        List<User> users = Arrays.asList(user1, user2);

        when(userRepository.findAll()).thenReturn(users);

        List<UserResponseDTO> userResponseDTOs = userService.getListUser();

        assertEquals(2, userResponseDTOs.size());
        assertEquals(user1.getId(), userResponseDTOs.get(0).getId());
    }
}
