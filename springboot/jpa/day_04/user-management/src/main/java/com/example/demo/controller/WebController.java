package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.entity.Topic;
import com.example.demo.service.WebService;
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
public class WebController {
    private final WebService webService;
    private final TopicService topicService;


    @GetMapping("/")
    public String getAllCourse(@RequestParam(required = false, defaultValue = "1") Integer page,
                               @RequestParam(required = false, defaultValue = "6") Integer pageSize,
                               @RequestParam(required = false) String topic,
                               @RequestParam(required = false) String term,
                               Model model) {
        Page<Course> pageInfo = webService.getAllCourse(page, pageSize);
        List<Topic> topicList = topicService.getAllTopic();

        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("currentPage", page);
        model.addAttribute("topicList", topicList);
        return "web/course-list";
    }

    @GetMapping("/khoa-hoc/online")
    public String getOnlineCourse(@RequestParam(required = false, defaultValue = "1") Integer page,
                                  @RequestParam(required = false, defaultValue = "6") Integer pageSize,
                                  Model model) {
        Page<Course> pageInfo = webService.getAllCourse(page, pageSize, "online");
        List<Topic> topicList = topicService.getAllTopic();

        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("currentPage", page);
        model.addAttribute("topicList", topicList);
        return "web/course-online-list";
    }

    @GetMapping("/khoa-hoc/onlab")
    public String getOnLabCourse(Model model) {
        List<Course> courseList = webService.getAllCourse("onlab");
        List<Topic> topicList = topicService.getAllTopic();

        model.addAttribute("courseList", courseList);
        model.addAttribute("topicList", topicList);
        return "web/course-onlab-list";
    }

    @GetMapping("/khoa-hoc/{id}")
    public String getDetailCourse(@PathVariable Integer id, Model model) {
        Course course = webService.getCourseDetail(id);
        model.addAttribute("course", course);
        return "web/detail";
    }
}
