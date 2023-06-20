package com.example.demo.controller;

import com.example.demo.model.Course;
import com.example.demo.model.Topic;
import com.example.demo.service.CourseService;
import com.example.demo.service.TopicService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class CourseController {
    private final CourseService courseService;
    private final TopicService topicService;


    @GetMapping("/")
    public String getAllCourse(@RequestParam(required = false, defaultValue = "1") Integer page,
                               @RequestParam(required = false, defaultValue = "6") Integer pageSize,
                               Model model) {
        Page<Course> pageInfo = courseService.getAllCourse(page, pageSize);
        List<Topic> topicList = topicService.getAllTopic();

        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("topicList", topicList);
        return "course-list";
    }

    @GetMapping("/khoa-hoc/online")
    public String getOnlineCourse(@RequestParam(required = false, defaultValue = "1") Integer page,
                                  @RequestParam(required = false, defaultValue = "6") Integer pageSize,
                                  Model model) {
        Page<Course> pageInfo = courseService.getAllCourse(page, pageSize, "online");
        List<Topic> topicList = topicService.getAllTopic();

        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("topicList", topicList);
        return "course-online-list";
    }

    @GetMapping("/khoa-hoc/onlab")
    public String getOnLabCourse(Model model) {
        List<Course> courseList = courseService.getAllCourse("onlab");
        List<Topic> topicList = topicService.getAllTopic();

        model.addAttribute("courseList", courseList);
        model.addAttribute("topicList", topicList);
        return "course-onlab-list";
    }

    @GetMapping("/khoa-hoc/{id}")
    public String getDetailCourse(@PathVariable Integer id, Model model) {
        Course course = courseService.getCourseDetail(id);
        model.addAttribute("course", course);
        return "detail";
    }
}
