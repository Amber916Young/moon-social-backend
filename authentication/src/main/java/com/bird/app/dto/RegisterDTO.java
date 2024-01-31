package com.bird.app.dto;

import com.bird.enums.Role;
import com.bird.enums.UserStatus;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RegisterDTO {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email; // unique key
    private String phone;
    private String password;
    private LocalDate dateOfBirth;
}
