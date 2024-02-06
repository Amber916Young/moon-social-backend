package com.tothemoon.app.mapper;

import com.tothemoon.app.dto.MemberDTO;
import com.tothemoon.common.entity.Member;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface MemberMapper {
    MemberDTO toDTO(Member member);

    Member toEntity(MemberDTO memberDTO);

    List<MemberDTO> toDTOList(List<Member> members);
}
