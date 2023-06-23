package com.example.demo;

import com.example.demo.entity.Course;
import com.example.demo.entity.Supporter;
import com.example.demo.entity.Topic;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.SupporterRepository;
import com.example.demo.repository.TopicRepository;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class UserManagementApplicationTests {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private SupporterRepository supporterRepository;
    @Autowired
    private TopicRepository topicRepository;

    @Test
    void save_topic() {
        List<Topic> topicList = List.of(
                new Topic(null, "backend"),
                new Topic(null, "frontend"),
                new Topic(null, "devops"),
                new Topic(null, "mobile"),
                new Topic(null, "database")
        );
        topicRepository.saveAll(topicList);
    }

    @Test
    void save_user() {
        Faker faker = new Faker();
        List<Supporter> supporters = List.of(
                new Supporter(null, "Đức Thịnh", "thinh@gmail.com", "0988888888", faker.company().logo()),
                new Supporter(null, "Phạm Mẫn", "man@gmail.com", "0977777777", faker.company().logo()),
                new Supporter(null, "Thanh Hương", "huong@gmail.com", "0966666666", faker.company().logo())
        );

        supporterRepository.saveAll(supporters);
    }

    @Test
    void save_course() {
        Faker faker = new Faker();
        Random rd = new Random();

        List<Supporter> supporterList = supporterRepository.findAll();
        List<Topic> topicList = topicRepository.findAll();

        for (int i = 0; i < 20; i++) {
            // Random 1 supporter
            Supporter rdSupporter = supporterList.get(rd.nextInt(supporterList.size()));

            // Random 1 ds category
            Set<Topic> rdTopicList = new LinkedHashSet<>();
            for (int j = 0; j < 3; j++) {
                Topic rdTopic = topicList.get(rd.nextInt(topicList.size()));
                rdTopicList.add(rdTopic);
            }

            // Tạo course
            Course course = Course.builder()
                    .name(faker.book().title())
                    .description(faker.lorem().sentence(15))
                    .type(rd.nextInt(2) == 0 ? "online" : "onlab")
                    .thumbnail(faker.company().logo())
                    .supporter(rdSupporter)
                    .topics(rdTopicList)
                    .build();

            courseRepository.save(course);
        }
    }

}
