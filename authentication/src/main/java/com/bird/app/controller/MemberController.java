package com.bird.app.controller;

import com.bird.app.dto.LoginDTO;
import com.bird.app.dto.LoginSuccessDTO;
import com.bird.app.dto.MemberDTO;
import com.bird.app.dto.RegisterDTO;
import com.bird.app.service.MemberService;
import com.bird.common.config.security.UserDetailsImpl;
import com.bird.enums.Role;
import com.bird.exception.ErrorReasonCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    //1.register
    //2.fetch
    //3.update
    //4.follow // unfollow
    private final MemberService memberService;

    @PostMapping("/register")
    public ResponseEntity<RegisterDTO> register(@Valid @RequestBody RegisterDTO registerDTO) {




    }


}
