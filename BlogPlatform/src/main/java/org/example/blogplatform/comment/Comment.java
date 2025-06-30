package org.example.blogplatform.comment;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.blogplatform.post.Post;
import org.example.blogplatform.user.BaseEntity;
@Entity
@Table(name ="comments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment extends BaseEntity {


    @Column(nullable = false)
    private String commenter_name;

    @Column(nullable = false)
    private String content;




    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    @JsonBackReference
    private Post post;

}
