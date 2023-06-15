package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CourseController {
    @GetMapping("/")
    public String getAllCourse() {
        return null;
    }

    @GetMapping("/")
    public String getOnlineCourse() {
        return null;
    }

    @GetMapping("/")
    public String getOnLabCourse() {
        return null;
    }
}
