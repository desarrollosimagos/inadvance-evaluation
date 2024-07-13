package org.inadvance.dto;
import java.time.LocalDateTime;
import java.util.UUID;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;

@ApiModel(description = "Details about the user response")
public class UserResponseDTO {
    @Schema(name = "ID", example = "ba2067f3-99fc-4508-a5da-908a62dd594f")
    @ApiModelProperty(notes = "The unique ID of the user",example = "ba2067f3-99fc-4508-a5da-908a62dd594f")
    private UUID id;
    @ApiModelProperty(notes = "The date and time when the user was created",example = "2024-07-13T11:15:48.122")
    private LocalDateTime created;
    @ApiModelProperty(notes = "The date and time when the user was last modified",example = "2024-07-13T11:15:48.122")
    private LocalDateTime modified;
    @ApiModelProperty(notes = "The date and time when the user last logged in",example = "2024-07-13T11:15:48.122")
    private LocalDateTime lastLogin;
    @ApiModelProperty(notes = "The JWT token assigned to the user",example = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqdWFuQHJvZHJpZ3Vlei5vcmciLCJpYXQiOjE3MjA4ODM3NDcsImV4cCI6MTcyMDkxOTc0N30.V8oW6vcHkrgnmdbc4z8XTMcF-6i2ZRW8i5gMuljBTgY")
    private String token;
    @ApiModelProperty(notes = "The active status of the user",example = "true")
    private boolean active;
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public LocalDateTime getCreated() {
        return created;
    }
    public void setCreated(LocalDateTime created) {
        this.created = created;
    }
    public LocalDateTime getModified() {
        return modified;
    }
    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }
    public LocalDateTime getLastLogin() {
        return lastLogin;
    }
    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
}
