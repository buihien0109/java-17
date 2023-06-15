package com.example.demojparelationship.controller;

import com.example.demojparelationship.service.ImageService;
import com.example.demojparelationship.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class WebController {
    private final UserService userService;
    private final ImageService imageService;

    @GetMapping("/")
    public String getUserPage(Model model) {
        return "index";
    }

    @GetMapping("/users/{id}/files")
    public String getFilesPage(Model model, @PathVariable Integer id) {
        return "file";
    }
}
