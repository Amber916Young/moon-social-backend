package com.bird.common.config.security;


import com.bird.common.repository.MemberRepository;
import com.bird.common.entity.Member;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("CompanyUser Not Found with email: " + email));

        if (BooleanUtils.isTrue(member.getFirstTimeLogin())) {
            member.setFirstTimeLogin(false);
            memberRepository.save(member);
        }

        return new UserDetailsImpl(member);
    }

}