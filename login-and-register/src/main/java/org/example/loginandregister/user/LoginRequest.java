package org.example.loginandregister.user;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LoginRequest {
    @NotBlank(message = "Please enter your username")
    @Size(max = 50, message ="your username should not exceed 50 characters" )
    private String username;
    @Email
    @Column(unique = true, nullable = false)
    private String email;
    @NotBlank(message = "Please enter your password")
    @Size(min = 5, message ="your name password should atleast exceed 5 characters" )
    private String password;
}
