package com.example.demojpa;

import com.example.demojpa.entity.Todo;
import com.example.demojpa.repository.TodoRepository;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
public class TodoTest {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private Faker faker;

    @Test
    void save_todo() {
        Random rd = new Random();
        for (int i = 0; i < 5; i++) {
            Todo todo = new Todo();
            todo.setTitle(faker.name().fullName());
            todo.setStatus(rd.nextInt(2) == 1);

            todoRepository.save(todo);
        }
    }
}
