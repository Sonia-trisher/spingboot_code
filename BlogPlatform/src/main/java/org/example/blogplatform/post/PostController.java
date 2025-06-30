package org.example.blogplatform.post;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.blogplatform.comment.Comment;
import org.example.blogplatform.comment.CommentCreationDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Tag(name = "Post" ,description = "The post are found here")
public class PostController {
    private final PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = postService.findAll();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable long id) {
        Post post = postService.FindPostById(id);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable long id, @RequestBody PostCreationDto dto) {
        Post post = postService.updatePost(id,dto);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable long id) {
        postService.deletePost(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Post>> searchPost(@RequestParam(name = "q") String query) {
        var posts = postService.findByQuery(query);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
    @PostMapping("/{postId}/comment")
    public ResponseEntity<Comment> addComment(@PathVariable long postId, @RequestBody CommentCreationDto dto) {
        var comment = postService.createComment(postId, dto);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }
    @GetMapping("/{postId}/comments")
    public ResponseEntity<List<Comment>> getComments(@PathVariable long postId) {
        var comment = postService.getCommentsByPostId(postId);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }


}
