package telran.java2022.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import telran.java2022.post.dao.PostRepository;
import telran.java2022.post.model.Post;

@Service
@RequiredArgsConstructor
public class CustomWebSecurity {
    final PostRepository postRepository;

    public boolean checkPostAuthor(String postId, String username){
        Post post = postRepository.findById(postId).orElse(null);
        return post != null && username.equalsIgnoreCase(post.getAuthor());

    }

}
