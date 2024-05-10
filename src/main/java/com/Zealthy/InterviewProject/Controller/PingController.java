package com.Zealthy.InterviewProject.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/ping")
@RestController
public class PingController {
    
    @GetMapping
    public ResponseEntity<String> ping() {
        return ResponseEntity.ok(java.time.LocalDateTime.now().toString());
    }}
