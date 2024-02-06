package com.bird.app.service;

import com.bird.common.entity.Member;
import com.bird.common.repository.MemberRepository;
import com.bird.enums.UserStatus;
import com.bird.exception.BadRequestException;
import com.bird.exception.ErrorReasonCode;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AuthenticationService {
    private final static String RESET_PASSWORD_LINK = "%s/auth/reset-password/%s";
    private final static String RESET_PASSWORD_SUBJECT = "Reset Your Order It Password";
    private final MemberRepository memberRepository;
    private final PasswordEncoder encoder;

    @Value("${application.app-url}")
    private String hostUrl;



    public void forgotPassword(String email) {
        log.debug("Forgot password triggered for {}", email);

        memberRepository.findByEmail(email).ifPresent(user -> {
            String randomKey = RandomString.make(10);
            user.setResetKey(randomKey);
            memberRepository.save(user);
            // TODO send to email
//            sendResetPasswordEmail(user.getFirstName() + " " + user.getLastName(), user.getEmail(), randomKey);
        });
    }

    public void resetPassword(String resetKey, String password) {
        log.debug("Reset password triggered for resetKey {}", resetKey);

        if (Objects.isNull(resetKey) || resetKey.isEmpty()) {
            throw new BadRequestException(ErrorReasonCode.Invalid_Reset_Key);
        }

        Member member = memberRepository.findByResetKey(resetKey).orElseThrow(() -> new BadRequestException(ErrorReasonCode.Invalid_Reset_Key));

        member.setResetKey(null);
        member.setPassword(encoder.encode(password));
        member.setStatus(UserStatus.ACTIVE);
        memberRepository.save(member);
    }


}
