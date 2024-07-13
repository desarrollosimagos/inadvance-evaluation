package org.inadvance.dto;
import javax.validation.constraints.NotBlank;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Details about the user request")
public class UserRequestDTO {
    @ApiModelProperty(notes = "The user's name", required = true,example = "Omar Orozco")
    @NotBlank(message = "Name is mandatory")
    private String name;
    @ApiModelProperty(notes = "The user's email", required = true,example = "ing.omar.orozco@gmail.com")
    @NotBlank(message = "Email is mandatory")
    private String email;
    @ApiModelProperty(notes = "The user's password", required = true,example = "SecurePassword123")
    @NotBlank(message = "Password is mandatory")
    private String password;

    @ApiModelProperty(notes = "List of phones associated with the user")
    private List<PhoneDTO> phones;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<PhoneDTO> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneDTO> phones) {
        this.phones = phones;
    }


}
