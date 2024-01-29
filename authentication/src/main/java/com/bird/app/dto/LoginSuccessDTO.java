package com.bird.app.dto;

import com.bird.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class LoginSuccessDTO {
    private String jwt;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Role role;

}
