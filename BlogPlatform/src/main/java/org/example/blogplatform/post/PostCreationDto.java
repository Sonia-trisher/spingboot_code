package org.example.blogplatform.post;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostCreationDto {
    @NotBlank
    private String Title;
    @NotBlank
    private String Content;
}
