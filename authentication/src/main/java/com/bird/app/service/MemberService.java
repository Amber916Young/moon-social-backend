package com.bird.app.service;

import com.bird.app.repository.MemberRepository;
import com.bird.common.entity.Member;
import com.bird.enums.UserStatus;
import com.bird.exception.BadRequestException;
import com.bird.exception.ErrorReasonCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
import javax.transaction.Transactional;
import java.util.Objects;


@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder encoder;

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
