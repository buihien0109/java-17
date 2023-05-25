package com.example.demojpa;

import com.example.demojpa.entity.User;
import com.example.demojpa.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class DemoJpaApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    void save_user() {
        User user = new User(null, "Hiên", "hien@gmail.com", LocalDate.now().plusYears(26), true);
        userRepository.save(user);
    }

    @Test
    void save_user_list() {
        List<User> userList = List.of(
                new User(null, "a", "a@gmail.com", LocalDate.now().minusYears(26), true),
                new User(null, "b", "b@gmail.com", LocalDate.now().minusYears(30), false),
                new User(null, "c", "c@gmail.com", LocalDate.now().minusYears(40), false)
        );
        userRepository.saveAll(userList);
    }

    @Test
    void find_user() {
        // Tìm theo id
        Optional<User> userOptional = userRepository.findById(1);
        if(userOptional.isPresent()) {
            System.out.println(userOptional.get());
        }

        // Cập nhật
        User user = userOptional.get();
        user.setName("Bùi Hiên update");
        userRepository.save(user);

        // findAll : Lấy tất cả
        List<User> userList = userRepository.findAll();
        userList.forEach(System.out::println);
    }

//    @Test
//    void test_findByName() {
//        List<User> userList = userRepository.findByName("a");
//        userList.forEach(System.out::println);
//
//        System.out.println("existsByEmail");
//        boolean isExist = userRepository.existsByEmail("d@gmail.com");
//        System.out.println(isExist);
//    }


    @Test
    void example_test() {
        User user = userRepository.findByEmail("a@gmail.com").orElse(null);
        User user1 = userRepository.findByEmailUsingJPQL("a@gmail.com").orElse(null);
        User user2 = userRepository.findByEmailUsingNativeQuery("a@gmail.com").orElse(null);

        System.out.println("user " + user);
        System.out.println("user1 " + user1);
        System.out.println("user2 " + user2);
    }
}
