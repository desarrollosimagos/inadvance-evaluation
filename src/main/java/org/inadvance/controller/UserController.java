package org.inadvance.controller;

import io.swagger.annotations.*;
import org.inadvance.dto.ErrorResponseDTO;
import org.inadvance.dto.UserRequestDTO;
import org.inadvance.dto.UserResponseDTO;
import org.inadvance.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@Api(value = "User Management System", description = "Operations pertaining to user in User Management System")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @ApiOperation(value = "Add a new user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully added user", response = UserResponseDTO.class),
            @ApiResponse(code = 400, message = "Bad Request",response = ErrorResponseDTO.class)
    })
    @PostMapping("/add")
    public ResponseEntity<UserResponseDTO> createUser(
            @ApiParam(value = "User details for the new user to be created in database", required = true, example = "{ \"name\": \"Juan Rodriguez\", \"email\": \"juan@rodriguez.org\", \"password\": \"SecurePassword123\", \"phones\": [{ \"number\": \"1234567\", \"cityCode\": \"1\", \"countryCode\": \"57\" }] }")
            @Valid @RequestBody UserRequestDTO user
    ) {
        UserResponseDTO createdUser = userService.registerUser(user);
        return ResponseEntity.ok(createdUser);
    }
    @ApiOperation(value = "View a list of available users")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list", response = UserResponseDTO.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Bad Request",response = ErrorResponseDTO.class)
    })
    @GetMapping("/all")
    public ResponseEntity<List<UserResponseDTO>> getListUser(){
            List<UserResponseDTO> users = userService.getListUser();
            return ResponseEntity.ok(users);
    }

}
