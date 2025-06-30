package org.example.blogplatform.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;


@Entity
@Table(name ="profile")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile extends BaseEntity {
    private String bio;
    private LocalDate dod;
    @Column(nullable = false,name = "full_names")
    private String Full_name;

    @OneToOne
    @JoinColumn(name = "user_id",unique = true)
    @JsonBackReference
    private User user;






}
