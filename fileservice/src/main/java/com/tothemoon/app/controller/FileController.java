package com.tothemoon.app.controller;

import com.tothemoon.app.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/files")
@RequiredArgsConstructor
@Slf4j
public class FileController {
    private final FileService fileService;

    @PostMapping(value = "/profile-image")
    public ResponseEntity<?> uploadProfileImage(@RequestParam("file") MultipartFile file) throws IOException {
        String url = fileService.uploadProfileImage(file);
        return new ResponseEntity<>(url, HttpStatus.OK);
    }

    @PostMapping(value = "/post-image")
    public ResponseEntity<?> uploadPostImage(@RequestParam("file") MultipartFile file) throws IOException {
        String url = fileService.uploadPostImage(file);
        return new ResponseEntity<>(url, HttpStatus.OK);
    }

    @DeleteMapping(value = "/post-image")
    public ResponseEntity<?> deletePostImage(@RequestBody String imageUrl) throws IOException {
        fileService.deletePostImage(imageUrl);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
