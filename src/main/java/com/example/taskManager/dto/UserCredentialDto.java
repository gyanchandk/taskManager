package com.example.taskManager.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCredentialDto {
    @NotBlank
    @Size(min = 4)
    @Email
    private String email;

    @NotBlank
    @Size(min = 4)
    private String password;
}
