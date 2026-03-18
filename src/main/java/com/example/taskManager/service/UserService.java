package com.example.taskManager.service;

import com.example.taskManager.dto.TaskDto;
import com.example.taskManager.dto.UserCredentialDto;
import com.example.taskManager.dto.UserWithTasks;
import com.example.taskManager.exception.UserNotFoundException;
import com.example.taskManager.model.User;
import com.example.taskManager.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public String signUp(UserCredentialDto credentialDto){

        String email = credentialDto.getEmail();

        if (userRepository.existsByEmail(email)){
            log.info("username already in the database");
            throw  new RuntimeException("User already exists");
        }

        String hashedPassword = passwordEncoder.encode(credentialDto.getPassword());

        log.info("hashed password generated for {}",email);
        User newUser = new User();
        newUser.setEmail(email);
        newUser.setPassword(hashedPassword);

        User savedUser = userRepository.save(newUser);
        log.info("user created with id: {}",savedUser.getId());

        return "new user created with id:"+savedUser.getId();

    }

    public String login(UserCredentialDto credentialDto){
        String email = credentialDto.getEmail();
        return userRepository.findByEmail(email)
                .map(user->{
                    String password = credentialDto.getPassword();
                    if (!passwordEncoder.matches(password,user.getPassword())){
                        throw  new RuntimeException("Invalid credentials");
                    }
                    return "Login success with token";
                })
                .orElseThrow(UserNotFoundException::new);


    }

    public UserWithTasks getAllTasks(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        List<TaskDto> taskDtos = user.getTasks()
                .stream()
                .map(task -> new TaskDto(
                        task.getId(),
                        task.getTitle(),
                        task.getContent(),
                        task.getStatus()))
                .toList();

        return new UserWithTasks(user.getId(), user.getEmail(), taskDtos);
    }

}
