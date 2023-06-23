package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Supporter;
import com.example.demo.entity.Topic;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.request.UpsertCourseRequest;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.SupporterRepository;
import com.example.demo.repository.TopicRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final SupporterRepository supporterRepository;
    private final TopicRepository topicRepository;

    public Page<Course> getAllCourse(Integer page, Integer pageSize) {
        Pageable pageRequest = PageRequest.of(page - 1, pageSize);
        return courseRepository.findAll(pageRequest);
    }

    public Course getCourseById(Integer id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> {
                    throw new NotFoundException("Not found course with id = " + id);
                });
    }

    public Course createCourse(UpsertCourseRequest request) {
        // Tìm kiếm supporter
        Supporter supporter = supporterRepository.findById(request.getSupporterId())
                .orElseThrow(() -> {
                    throw new NotFoundException("Not found supporter with id = " + request.getSupporterId());
                });

        // Tìm kiếm danh sách topic
        Set<Topic> topics = topicRepository.findByIdIn(request.getTopicIds());

        // Tạo khóa học
        Course course = Course.builder()
                .name(request.getName())
                .description(request.getDescription())
                .type(request.getType())
                .topics(topics)
                .supporter(supporter)
                .build();

        courseRepository.save(course);
        return course;
    }

    public Course updateCourse(int id, UpsertCourseRequest request) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> {
                    throw new NotFoundException("Not found course with id = " + id);
                });

        // Tìm kiếm supporter
        Supporter supporter = supporterRepository.findById(request.getSupporterId())
                .orElseThrow(() -> {
                    throw new NotFoundException("Not found supporter with id = " + request.getSupporterId());
                });

        // Tìm kiếm danh sách topic
        Set<Topic> topics = topicRepository.findByIdIn(request.getTopicIds());

        course.setName(request.getName());
        course.setDescription(request.getDescription());
        course.setType(request.getType());
        course.setSupporter(supporter);
        course.setTopics(topics);
        course.setThumbnail(request.getThumbnail());

        courseRepository.save(course);
        return course;
    }

    public void deleteCourse(Integer id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> {
                    throw new NotFoundException("Not found course with id = " + id);
                });
        courseRepository.delete(course);
    }
}
