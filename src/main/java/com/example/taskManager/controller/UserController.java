package com.example.taskManager.controller;

import com.example.taskManager.dto.UserWithTasks;
import com.example.taskManager.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<UserWithTasks> getUserWithTasks(){
        return ResponseEntity.ok(userService.getAllTasks(1L));
    }
}
