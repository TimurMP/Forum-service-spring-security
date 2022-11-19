package telran.java2022.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import telran.java2022.accounting.dao.UserAccountRepository;
import telran.java2022.accounting.model.UserAccount;
import telran.java2022.post.dao.PostRepository;
import telran.java2022.post.model.Post;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CustomWebSecurity {
    final PostRepository postRepository;
    final UserAccountRepository userAccountRepository;

    public boolean checkPostAuthor(String postId, String username) {
        Post post = postRepository.findById(postId).orElse(null);
        return post != null && username.equalsIgnoreCase(post.getAuthor());

    }

    public boolean isPasswordExpired(String username) {
        UserAccount userAccount = userAccountRepository.findById(username).orElse(null);
        LocalDateTime now = LocalDateTime.now();

        if (userAccount != null) {
            if (userAccount.getPasswordChanged() == null) {
//                System.out.println("no time");
                return false;
            }
            LocalDateTime userTime = userAccount.getPasswordChanged().plusDays(60);
            if (!now.isAfter(userTime)) {
//                System.out.println("not expired");
                return true;
            }
        }
//        System.out.println("expired");
        return false;
    }

}
