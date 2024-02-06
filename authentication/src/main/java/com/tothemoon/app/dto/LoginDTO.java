package com.tothemoon.app.dto;

import com.bird.enums.LoginIdentifierType;
import lombok.Data;

@Data
public class LoginDTO {
    private String loginIdentifier;
    private LoginIdentifierType identifierType;
    private String password;
}
