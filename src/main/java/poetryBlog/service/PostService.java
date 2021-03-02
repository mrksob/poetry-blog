package poetryBlog.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import poetryBlog.dto.PostRequest;
import poetryBlog.dto.PostResponse;
import poetryBlog.model.Post;
import poetryBlog.model.User;
import poetryBlog.repository.PostRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public void save(PostRequest postRequest) {

    }

    public PostResponse findPost(Long id) {
        return null;
    }

    public List<PostResponse> findAllPosts() {
        return null;
    }

    public List<PostResponse> findAllPostsByUsername(String username) {
        return null;
    }

    public Post mapToPost(PostRequest postRequest , User user) {
        return Post.builder()
                .description(postRequest.getDescription())
                .url(postRequest.getUrl())
                .postName(postRequest.getPostName())
                .createdAt(java.time.Instant.now())
                .user(user)
                .build();
    }

    public PostResponse mapToDto(Post post) {
        return PostResponse.builder()
                .id(post.getId())
                .postName(post.getPostName())
                .url(post.getUrl())
                .description(post.getDescription())
                .username(post.getUser().getUsername())
                .build();
    }
}
