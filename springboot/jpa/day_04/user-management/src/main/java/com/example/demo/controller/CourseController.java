package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.entity.Supporter;
import com.example.demo.entity.Topic;
import com.example.demo.model.request.UpsertCourseRequest;
import com.example.demo.service.CourseService;
import com.example.demo.service.SupporterService;
import com.example.demo.service.TopicService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
public class CourseController {
    private final CourseService courseService;
    private final TopicService topicService;
    private final SupporterService supporterService;

    // Danh sách View
    @GetMapping("admin/courses")
    public String getCoursesPage(
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "10") int pageSize,
            Model model) {
        Page<Course> pageInfo = courseService.getAllCourse(page, pageSize);

        model.addAttribute("currentPage", page);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/course/course-list";
    }

    @GetMapping("admin/courses/create")
    public String getCreateCoursePage(Model model) {
        List<Topic> topicList = topicService.getAllTopic();
        List<Supporter> supporterList = supporterService.getAllSupporter();

        model.addAttribute("topicList", topicList);
        model.addAttribute("supporterList", supporterList);

        return "admin/course/course-create";
    }

    @GetMapping("admin/courses/{id}")
    public String getDetailCoursePage(@PathVariable Integer id, Model model) {
        List<Topic> topicList = topicService.getAllTopic();
        List<Supporter> supporterList = supporterService.getAllSupporter();
        Course course = courseService.getCourseById(id);

        model.addAttribute("topicList", topicList);
        model.addAttribute("supporterList", supporterList);
        model.addAttribute("course", course);
        return "admin/course/course-detail";
    }

    // Danh sách API
    @PostMapping("api/admin/courses")
    public ResponseEntity<?> createCourse(@Valid @RequestBody UpsertCourseRequest request) {
        Course course = courseService.createCourse(request);
        return new ResponseEntity<>(course, HttpStatus.CREATED);
    }

    @PutMapping("api/admin/courses/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable Integer id, @Valid @RequestBody UpsertCourseRequest request) {
        Course course = courseService.updateCourse(id, request);
        return ResponseEntity.ok(course);
    }

    @DeleteMapping("api/admin/courses/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
}
