package org.example.blogplatform.user.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateProfileDto {
    @NotBlank
    private String fullName;
    @NotBlank
    private String bio;
    private LocalDate dob;
}
