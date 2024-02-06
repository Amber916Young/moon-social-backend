package com.bird.app.controller;

import com.bird.app.dto.MemberDTO;
import com.bird.app.dto.RegisterDTO;
import com.bird.app.mapper.MemberMapper;
import com.bird.app.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    //1.fetch
    //2.update
    //3.follow // unfollow
    private final MemberService memberService;
    private final MemberMapper memberMapper;

    @GetMapping("/fetch")
    public ResponseEntity<MemberDTO> fetchMyProfile() {
        return new ResponseEntity<>(memberMapper.toDTO(memberService.getMember()), HttpStatus.OK);
    }
    @GetMapping("/fetch/{userId}")
    public ResponseEntity<MemberDTO> fetchUserById(@PathVariable Long userId) {
        return new ResponseEntity<>(memberMapper.toDTO(memberService.getMemberById(userId)), HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<MemberDTO> updateUser(@Valid @RequestBody MemberDTO memberDTO) {
        return new ResponseEntity<>(memberMapper.toDTO(memberService.updateMember(memberDTO)), HttpStatus.OK);
    }


}
