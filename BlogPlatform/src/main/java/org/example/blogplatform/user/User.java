package org.example.blogplatform.user;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.example.blogplatform.post.Post;
import java.util.List;

@Entity
@Table(name ="app_users_table")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {


    @Column (unique = true, nullable = false)
    private String Username;

    @Column (unique = true, nullable = false)
    private String email;


    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Profile Profile;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Post> posts;


}
