package com.tothemoon.app.mapper;

import com.tothemoon.app.dto.BasicPostDTO;
import com.tothemoon.app.dto.PostDTO;
import com.tothemoon.common.entity.Post;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-22T10:25:24+0000",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_352 (Amazon.com Inc.)"
)
@Component
public class PostMapperImpl implements PostMapper {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PostDTO toDTO(Post post) {
        if ( post == null ) {
            return null;
        }

        PostDTO postDTO = new PostDTO();

        postDTO.setId( post.getId() );
        postDTO.setNumber( post.getNumber() );
        postDTO.setCreatedAt( post.getCreatedAt() );
        postDTO.setUser( post.getUser() );
        postDTO.setType( post.getType() );
        postDTO.setContent( post.getContent() );
        postDTO.setEditedAt( post.getEditedAt() );
        postDTO.setEditedUser( post.getEditedUser() );
        postDTO.setHiddenAt( post.getHiddenAt() );
        postDTO.setHiddenUser( post.getHiddenUser() );
        postDTO.setIpAddress( post.getIpAddress() );
        postDTO.setIsPrivate( post.getIsPrivate() );
        postDTO.setIsApproved( post.getIsApproved() );
        postDTO.setIsSpam( post.getIsSpam() );

        return postDTO;
    }

    @Override
    public BasicPostDTO toBasicPostDTO(Post post) {
        if ( post == null ) {
            return null;
        }

        BasicPostDTO basicPostDTO = new BasicPostDTO();

        basicPostDTO.setId( post.getId() );
        basicPostDTO.setNumber( post.getNumber() );
        basicPostDTO.setCreatedAt( post.getCreatedAt() );
        basicPostDTO.setUser( userMapper.toBasicUserInfoDTO( post.getUser() ) );
        basicPostDTO.setType( post.getType() );
        basicPostDTO.setContent( post.getContent() );
        basicPostDTO.setEditedAt( post.getEditedAt() );
        basicPostDTO.setEditedUser( userMapper.toBasicUserInfoDTO( post.getEditedUser() ) );

        return basicPostDTO;
    }

    @Override
    public Post toEntity(PostDTO postDTO) {
        if ( postDTO == null ) {
            return null;
        }

        Post post = new Post();

        post.setId( postDTO.getId() );
        post.setNumber( postDTO.getNumber() );
        post.setCreatedAt( postDTO.getCreatedAt() );
        post.setUser( postDTO.getUser() );
        post.setType( postDTO.getType() );
        post.setContent( postDTO.getContent() );
        post.setEditedAt( postDTO.getEditedAt() );
        post.setEditedUser( postDTO.getEditedUser() );
        post.setHiddenAt( postDTO.getHiddenAt() );
        post.setHiddenUser( postDTO.getHiddenUser() );
        post.setIpAddress( postDTO.getIpAddress() );
        post.setIsPrivate( postDTO.getIsPrivate() );
        post.setIsApproved( postDTO.getIsApproved() );
        post.setIsSpam( postDTO.getIsSpam() );

        return post;
    }

    @Override
    public List<PostDTO> toDTOList(List<Post> posts) {
        if ( posts == null ) {
            return null;
        }

        List<PostDTO> list = new ArrayList<PostDTO>( posts.size() );
        for ( Post post : posts ) {
            list.add( toDTO( post ) );
        }

        return list;
    }
}
