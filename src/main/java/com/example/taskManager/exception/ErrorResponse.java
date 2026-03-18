package com.example.taskManager.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ErrorResponse {
    private LocalDateTime timestamp;
    private int status;
    private String message;

    public ErrorResponse(int status,String message){
        this.status = status;
        this.message = message;
        timestamp = LocalDateTime.now();
    }
}
