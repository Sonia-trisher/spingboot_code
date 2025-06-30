package org.example.blogplatform.comment;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CommentCreationDto {
    @NotBlank
    private String commenter_name;
    @NotBlank
    private String content;
}
