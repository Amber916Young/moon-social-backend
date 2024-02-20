package com.tothemoon.app.mapper;

import com.tothemoon.app.dto.BasicDiscussionDTO;
import com.tothemoon.app.dto.DiscussionDTO;
import com.tothemoon.app.dto.DiscussionDetailDTO;
import com.tothemoon.common.entity.Discussion;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface DiscussionMapper {
    DiscussionDTO toDTO(Discussion discussion);
    DiscussionDetailDTO toDetailDTO(Discussion discussion);

    Discussion toEntity(DiscussionDTO discussionDTO);

    List<DiscussionDTO> toDTOList(List<Discussion> discussions);
    @Mapping(target = "commentCount", expression = "java(discussion.getComments().size())")
    @Mapping(target = "participantCount", expression = "java(discussion.getParticipants().size())")
    @Mapping(target = "postNumberIndex", source = "postNumberIndex")
    List<BasicDiscussionDTO> toBasicDTOList(List<Discussion> discussions);
}
