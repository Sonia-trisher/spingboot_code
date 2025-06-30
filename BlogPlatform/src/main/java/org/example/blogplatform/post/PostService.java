package org.example.blogplatform.post;

import lombok.RequiredArgsConstructor;
import org.example.blogplatform.comment.Comment;
import org.example.blogplatform.comment.CommentCreationDto;
import org.example.blogplatform.comment.CommentRepository;
import org.example.blogplatform.user.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository1;
    private final CommentRepository commentRepository1;

    public List<Post> findAll(){
        return postRepository1.findAll();
    }
    public Post FindPostById(Long id) {
        return postRepository1.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
    }
    public Post updatePost( Long id ,PostCreationDto dto){
        var post = postRepository1.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());
        return postRepository1.save(post);

    }
    public void deletePost(Long id) {
        var post = postRepository1.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        postRepository1.delete(post);
    }
    public List<Post> findByQuery(String query) {
        return postRepository1.findByTitleContainingIgnoreCase(query);
    }
    public Comment createComment(Long postId,CommentCreationDto dto) {
        var post = postRepository1.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
        Comment comment = new Comment();
        comment.setCommenter_name(dto.getCommenter_name());
        comment.setContent(dto.getContent());
        comment.setPost(post);
        return commentRepository1.save(comment);


    }
    public List<Comment> getCommentsByPostId(Long postId) {
        var post = postRepository1.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
        return post.getComments();


    }



}

