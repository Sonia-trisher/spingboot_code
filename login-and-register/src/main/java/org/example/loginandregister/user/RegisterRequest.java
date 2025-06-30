package org.example.loginandregister.user;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
@Data

public class RegisterRequest {
    @NotBlank(message = "Please enter your first name")
    @Size(max = 50, message ="your name should not exceed 50 characters" )
    private String firstName;
    @NotBlank(message = "Please enter your last name")
    @Size(max = 50, message ="your name should not exceed 50 characters" )
    private String lastName;
    @Email
    @Column(unique = true)
    private String email;
    @NotBlank(message = "Please enter your Password")
    @Size(min = 5, message ="your passcode should atleast be above 5 characters" )
    private String password;

}
