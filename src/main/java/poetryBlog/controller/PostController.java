package poetryBlog.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import poetryBlog.dto.PostRequest;
import poetryBlog.dto.PostResponse;
import poetryBlog.model.Post;
import poetryBlog.service.PostService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity createPost(@RequestBody PostRequest postRequest) {
        postService.save(postRequest);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public PostResponse getPost (@PathVariable Long id) {
        return postService.findPost(id);
    }

    @GetMapping("/")
    public List<PostResponse> getAllPosts() {
        return postService.findAllPosts();
    }

    @GetMapping("/by-user/{username}")
    public List<PostResponse> getPostsByUsername(String username) {
        return postService.findAllPostsByUsername(username);
    }
}
