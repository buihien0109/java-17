package com.example.demo.service;

import com.example.demo.entity.Topic;
import com.example.demo.repository.TopicRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TopicService {

    private final TopicRepository topicRepository;

    public List<Topic> getAllTopic() {
        return topicRepository.findAll();
    }
}
