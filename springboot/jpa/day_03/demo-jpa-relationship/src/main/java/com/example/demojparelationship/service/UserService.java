package com.example.demojparelationship.service;

import com.example.demojparelationship.entity.User;
import com.example.demojparelationship.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
