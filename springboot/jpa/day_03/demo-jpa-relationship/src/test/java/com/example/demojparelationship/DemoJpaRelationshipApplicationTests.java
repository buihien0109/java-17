package com.example.demojparelationship;

import com.example.demojparelationship.entity.IdentityCard;
import com.example.demojparelationship.entity.Post;
import com.example.demojparelationship.entity.User;
import com.example.demojparelationship.repository.IdentityCardRepository;
import com.example.demojparelationship.repository.PostRepository;
import com.example.demojparelationship.repository.UserRepository;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DemoJpaRelationshipApplicationTests {

    @Autowired
    private IdentityCardRepository identityCardRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;

    @Test
    @Rollback(value = false)
    void save_user_1() {
        // Tạo card
        IdentityCard identityCard = new IdentityCard(null, "111");
        identityCardRepository.save(identityCard);

        // Tạo user
//        User user = new User(null, "Nguễn Văn A", "a@gmail.com", "111", identityCard);
//        userRepository.save(user);
    }

    @Test
    @Rollback(value = false)
    void save_user_2() {
        User user = User.builder()
                .name("Trần Văn B")
                .email("b@gmail.com")
                .password("222")
                .identityCard(
                        new IdentityCard(null, "222")
                )
                .build();
        userRepository.save(user);
    }

    @Test
    void find_user() {
        User user = userRepository.findById(4).orElse(null);
        System.out.println(user);
    }

    @Test
    @Rollback(value = false)
    void delete_user() {
        userRepository.deleteById(2);
    }

    @Test
    @Rollback(value = false)
    void save_user_post() {
        User user = User.builder()
                .name("Trần Văn B")
                .email("b@gmail.com")
                .password("222")
                .build();

        userRepository.save(user);

        for (int i = 0; i < 5; i++) {
            Post post = new Post(null, "post-" + (i + 1), user);
            postRepository.save(post);
        }
    }

    @Test
    @Rollback(value = false)
    void orphan_removal() {
        User user = userRepository.findById(4).orElse(null);

        List<Post> posts = user.getPosts();
        posts.remove(0);
    }

    @Test
    void find_user_fetch() {
        User user = userRepository.findById(4).orElse(null);

        List<Post> posts = user.getPosts();
        posts.forEach(post -> System.out.println(post.getTitle()));
    }
}
