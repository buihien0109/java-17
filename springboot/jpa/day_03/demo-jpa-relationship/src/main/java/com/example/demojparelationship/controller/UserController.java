package com.example.demojparelationship.controller;

import com.example.demojparelationship.service.ImageService;
import com.example.demojparelationship.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    private final ImageService imageService;

    // 1. Upload file
    @PostMapping("{id}/files")
    public ResponseEntity<?> uploadFile(@ModelAttribute("file") MultipartFile file, @PathVariable Integer id) {
        return null;
    }
}
