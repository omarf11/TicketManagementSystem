package com.Zealthy.InterviewProject.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/ping")
@RestController
public class PingController {
    
    @GetMapping
    public ResponseEntity<String> ping() {

        try {
            return ResponseEntity.ok(java.time.LocalDateTime.now().toString());
        } catch (Exception e) {

            System.out.println(e.getMessage());
            e.printStackTrace();
  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred: " + e.getMessage());
        }
    }}
