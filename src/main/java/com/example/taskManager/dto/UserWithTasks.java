package com.example.taskManager.dto;

import com.example.taskManager.model.Task;
import com.example.taskManager.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class UserWithTasks {
    private Long userId;
    private String email;
    private List<TaskDto> tasks;
}
