package org.example.blogplatform.user;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.blogplatform.post.Post;
import org.example.blogplatform.post.PostCreationDto;
import org.example.blogplatform.user.Dto.CreateProfileDto;
import org.example.blogplatform.user.Dto.CreateUserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Tag(name = "User Controller",description = "these are user management system")

public class UserController {
    private final UserService userService;


    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody @Valid CreateUserDto dto) {
        User user = userService.createUser(dto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);

    }
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        var users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        var user = userService.getUserById(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    @PatchMapping("{id}")
    public  ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody @Valid CreateUserDto dto){
        User user = userService.updateUser(id, dto);
        return new ResponseEntity<>(user,HttpStatus.OK);

    }
    @PostMapping("/{userId}/profile")
    public ResponseEntity<Profile> createProfile(@PathVariable Long userId,@RequestBody @Valid CreateProfileDto dto) {
        var Profile = userService.createUserProfile(userId,dto);
        return new ResponseEntity<>(Profile,HttpStatus.CREATED);

    }
    @GetMapping("/{userId}/profile")
    public ResponseEntity<Profile> getUserProfiles(@PathVariable Long userId) {
        var profile = userService.getUserProfile(userId);
        return new ResponseEntity<>(profile,HttpStatus.OK);
    }
    @PostMapping("/{userId}/post")
    public ResponseEntity<Post> createPost(@PathVariable Long userId, @RequestBody @Valid PostCreationDto dto){
        var Post = userService.createPost(userId,dto);
        return new ResponseEntity<>(Post,HttpStatus.CREATED);

    }
    @GetMapping("/{userId}/post")
    public ResponseEntity<List<Post>> getPost(@PathVariable Long userId) {
        var posts = userService.getAllPosts(userId);
        return new ResponseEntity<>(posts,HttpStatus.OK);
    }

}
