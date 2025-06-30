package org.example.blogplatform.user.Dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserDto {
    @NotBlank(message = "User name is required ")
    private String Username;
    @NotBlank(message = "Email is required")
    @Email(message = "Enter a valid email")
    private String email;
    private String password;
}
