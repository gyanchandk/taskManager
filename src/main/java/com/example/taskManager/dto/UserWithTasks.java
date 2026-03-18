package com.example.taskManager.dto;

import com.example.taskManager.model.Task;
import com.example.taskManager.model.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserWithTasks {
    private User user;
    private List<Task> tasks;
}
