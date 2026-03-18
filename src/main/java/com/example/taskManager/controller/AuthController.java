package com.example.taskManager.controller;

import com.example.taskManager.dto.UserCredentialDto;
import com.example.taskManager.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity<String> userSignUp(@Valid @RequestBody
                                                UserCredentialDto credentialDto){
        log.info("POST : /auth/signUp endpoint is hit");
        return ResponseEntity.ok(userService.signUp(credentialDto));
    }

    @PostMapping("/login")
    public ResponseEntity<String> userLogin(@Valid @RequestBody
                                             UserCredentialDto credentialDto){
        log.info("POST : /auth/login endpoint is hit");
        return ResponseEntity.ok(userService.login(credentialDto));
    }



}
