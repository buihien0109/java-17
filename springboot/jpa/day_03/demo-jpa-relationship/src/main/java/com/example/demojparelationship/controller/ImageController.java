package com.example.demojparelationship.controller;

import com.example.demojparelationship.service.ImageService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/files")
@AllArgsConstructor
public class ImageController {
    private final ImageService imageService;

    // 1. Xem file
    @GetMapping("{id}")
    public ResponseEntity<?> readFile(@PathVariable Integer id) {
        return null;
    }

    // 2. Xóa file
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteFile(@PathVariable Integer id) {
        return null;
    }
}
