package org.example.blogplatform.user;


import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Var;
import org.example.blogplatform.post.Post;
import org.example.blogplatform.post.PostCreationDto;
import org.example.blogplatform.post.PostRepository;
import org.example.blogplatform.user.Dto.CreateProfileDto;
import org.example.blogplatform.user.Dto.CreateUserDto;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final ProfileRepository profileRepository1;
    private final PostRepository postRepository;


    public User createUser(CreateUserDto dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
    }

    public User updateUser(Long id, CreateUserDto dto) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        return userRepository.save(user);
    }
    public Profile createUserProfile(Long userId, CreateProfileDto dto) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Profile profile = new Profile();
        profile.setFull_name(dto.getFullName());
        profile.setBio(dto.getBio());
        profile.setDod(dto.getDob());
        var savedProfile = profileRepository1.save(profile);// aha usavinze table of profile ibyo bashizemo

        user.setProfile(savedProfile);//ushize profile to the user (but here u are setting

        var savedUser = userRepository.save(user); // here usave user which include profole

        return savedUser.getProfile();//uri ya user irimo profile tubone profile only


    }
        public Profile getUserProfile(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return user.getProfile();//cz here umu user ha containinzemo profile so that why dufata umu tureba muri user then tugashakamo profile in user

        }
        public Post  createPost(Long userId, PostCreationDto dto){
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Post post = new Post();
        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());
        post.setUser(user);
        return postRepository.save(post);
        }

        public List<Post> getAllPosts(Long userId) {
        User user = userRepository.findById((userId)).orElseThrow(() -> new RuntimeException("User not found"));
        return user.getPosts();
        }





}
