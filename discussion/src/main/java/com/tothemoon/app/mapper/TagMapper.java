package com.tothemoon.app.mapper;

import com.tothemoon.app.dto.BasicTagDTO;
import com.tothemoon.app.dto.TagDTO;
import com.tothemoon.common.entity.Tag;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface TagMapper {
    TagDTO toDTO(Tag tag);
    BasicTagDTO toBasicDTO(Tag tag);
    Tag toEntity(TagDTO tagDTO);
    List<TagDTO> toDTOList(List<Tag> tags);
}
