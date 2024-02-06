package com.tothemoon.app.mapper;

import com.tothemoon.app.dto.MemberDTO;
import com.tothemoon.common.entity.Member;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-06T12:55:51+0000",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_352 (Amazon.com Inc.)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public MemberDTO toDTO(Member member) {
        if ( member == null ) {
            return null;
        }

        MemberDTO memberDTO = new MemberDTO();

        return memberDTO;
    }

    @Override
    public Member toEntity(MemberDTO memberDTO) {
        if ( memberDTO == null ) {
            return null;
        }

        Member member = new Member();

        return member;
    }

    @Override
    public List<MemberDTO> toDTOList(List<Member> members) {
        if ( members == null ) {
            return null;
        }

        List<MemberDTO> list = new ArrayList<MemberDTO>( members.size() );
        for ( Member member : members ) {
            list.add( toDTO( member ) );
        }

        return list;
    }
}
