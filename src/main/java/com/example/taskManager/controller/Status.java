package com.example.taskManager.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/status")
public class Status {


    @GetMapping
    public ResponseEntity<String> get() {
        return ResponseEntity.ok("Server is up and running");
    }
}
