package com.tothemoon.app.mapper;

import com.tothemoon.app.dto.BasicPostDTO;
import com.tothemoon.app.dto.PostDTO;
import com.tothemoon.common.entity.Post;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {})
public interface PostMapper {
    PostDTO toDTO(Post post);
    BasicPostDTO toBasicDTO(Post post);
    Post toEntity(PostDTO postDTO);
    List<PostDTO> toDTOList(List<Post> posts);
}
