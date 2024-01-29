package com.bird.app.mapper;

import com.bird.app.dto.MemberDTO;
import com.bird.common.entity.Member;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface MemberMapper {
    MemberDTO toDTO(Member member);

    Member toEntity(MemberDTO memberDTO);

    List<MemberDTO> toDTOList(List<Member> members);
}
