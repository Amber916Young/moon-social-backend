package com.bird.app.dto;

import com.bird.enums.Role;
import com.bird.enums.UserStatus;
import lombok.Data;
import java.time.LocalDate;

@Data
public class MemberDTO {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private Long points;
    private String phone;
    private LocalDate dateOfBirth;
    private LocalDate lastLogin;
    private String bio;
    private String profileImageUrl;
    private Role role;
    private UserStatus status;
//    private List<Member> friends;
}
