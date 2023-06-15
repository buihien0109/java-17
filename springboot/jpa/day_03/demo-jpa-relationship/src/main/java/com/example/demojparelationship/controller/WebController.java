package com.example.demojparelationship.controller;

import com.example.demojparelationship.entity.Image;
import com.example.demojparelationship.entity.User;
import com.example.demojparelationship.service.ImageService;
import com.example.demojparelationship.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@AllArgsConstructor
public class WebController {
    private final UserService userService;
    private final ImageService imageService;

    @GetMapping("/")
    public String getUserPage(Model model) {
        List<User> userList = userService.getAllUser();
        model.addAttribute("userList", userList);
        return "index";
    }

    @GetMapping("/users/{id}/files")
    public String getFilesPage(Model model, @PathVariable Integer id) {
        List<Image> imageList = imageService.getImagesOfUser(id);
        model.addAttribute("imageList", imageList);
        model.addAttribute("userId", id);
        return "file";
    }
}
