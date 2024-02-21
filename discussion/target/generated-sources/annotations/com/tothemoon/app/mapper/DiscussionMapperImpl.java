package com.tothemoon.app.mapper;

import com.tothemoon.app.dto.BasicPostDTO;
import com.tothemoon.app.dto.BasicUserInfoDTO;
import com.tothemoon.app.dto.DiscussionDTO;
import com.tothemoon.common.entity.Discussion;
import com.tothemoon.common.entity.Post;
import com.tothemoon.common.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-21T15:39:17+0000",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_352 (Amazon.com Inc.)"
)
@Component
public class DiscussionMapperImpl implements DiscussionMapper {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PostMapper postMapper;

    @Override
    public DiscussionDTO toDTO(Discussion discussion) {
        if ( discussion == null ) {
            return null;
        }

        DiscussionDTO discussionDTO = new DiscussionDTO();

        discussionDTO.setId( discussion.getId() );
        discussionDTO.setTitle( discussion.getTitle() );
        discussionDTO.setCommentCount( discussion.getCommentCount() );
        discussionDTO.setParticipantCount( discussion.getParticipantCount() );
        discussionDTO.setPostNumberIndex( discussion.getPostNumberIndex() );
        discussionDTO.setCreatedAt( discussion.getCreatedAt() );
        discussionDTO.setUser( userMapper.toBasicUserInfoDTO( discussion.getUser() ) );
        discussionDTO.setFirstPost( postMapper.toBasicPostDTO( discussion.getFirstPost() ) );
        discussionDTO.setLastPostedAt( discussion.getLastPostedAt() );
        discussionDTO.setLastPostedUser( userMapper.toBasicUserInfoDTO( discussion.getLastPostedUser() ) );
        discussionDTO.setLastPost( postMapper.toBasicPostDTO( discussion.getLastPost() ) );
        discussionDTO.setLastPostNumber( discussion.getLastPostNumber() );
        discussionDTO.setSlug( discussion.getSlug() );
        discussionDTO.setIsPrivate( discussion.getIsPrivate() );
        discussionDTO.setIsApproved( discussion.getIsApproved() );
        discussionDTO.setIsSticky( discussion.getIsSticky() );
        discussionDTO.setIsLocked( discussion.getIsLocked() );
        discussionDTO.setIsPopular( discussion.getIsPopular() );
        discussionDTO.setViewCount( discussion.getViewCount() );
        discussionDTO.setVotes( discussion.getVotes() );

        return discussionDTO;
    }

    @Override
    public Discussion toEntity(DiscussionDTO discussionDTO) {
        if ( discussionDTO == null ) {
            return null;
        }

        Discussion discussion = new Discussion();

        discussion.setId( discussionDTO.getId() );
        discussion.setTitle( discussionDTO.getTitle() );
        discussion.setCommentCount( discussionDTO.getCommentCount() );
        discussion.setParticipantCount( discussionDTO.getParticipantCount() );
        discussion.setPostNumberIndex( discussionDTO.getPostNumberIndex() );
        discussion.setCreatedAt( discussionDTO.getCreatedAt() );
        discussion.setUser( basicUserInfoDTOToUser( discussionDTO.getUser() ) );
        discussion.setFirstPost( basicPostDTOToPost( discussionDTO.getFirstPost() ) );
        discussion.setLastPostedAt( discussionDTO.getLastPostedAt() );
        discussion.setLastPostedUser( basicUserInfoDTOToUser( discussionDTO.getLastPostedUser() ) );
        discussion.setLastPost( basicPostDTOToPost( discussionDTO.getLastPost() ) );
        discussion.setLastPostNumber( discussionDTO.getLastPostNumber() );
        discussion.setSlug( discussionDTO.getSlug() );
        discussion.setIsPrivate( discussionDTO.getIsPrivate() );
        discussion.setIsApproved( discussionDTO.getIsApproved() );
        discussion.setIsSticky( discussionDTO.getIsSticky() );
        discussion.setIsLocked( discussionDTO.getIsLocked() );
        discussion.setIsPopular( discussionDTO.getIsPopular() );
        discussion.setViewCount( discussionDTO.getViewCount() );
        discussion.setVotes( discussionDTO.getVotes() );

        return discussion;
    }

    @Override
    public List<DiscussionDTO> toDTOList(List<Discussion> discussions) {
        if ( discussions == null ) {
            return null;
        }

        List<DiscussionDTO> list = new ArrayList<DiscussionDTO>( discussions.size() );
        for ( Discussion discussion : discussions ) {
            list.add( toDTO( discussion ) );
        }

        return list;
    }

    protected User basicUserInfoDTOToUser(BasicUserInfoDTO basicUserInfoDTO) {
        if ( basicUserInfoDTO == null ) {
            return null;
        }

        User user = new User();

        user.setId( basicUserInfoDTO.getId() );
        user.setUsername( basicUserInfoDTO.getUsername() );
        user.setNickname( basicUserInfoDTO.getNickname() );
        user.setAvatarUrl( basicUserInfoDTO.getAvatarUrl() );

        return user;
    }

    protected Post basicPostDTOToPost(BasicPostDTO basicPostDTO) {
        if ( basicPostDTO == null ) {
            return null;
        }

        Post post = new Post();

        post.setId( basicPostDTO.getId() );
        post.setNumber( basicPostDTO.getNumber() );
        post.setCreatedAt( basicPostDTO.getCreatedAt() );
        post.setUser( basicUserInfoDTOToUser( basicPostDTO.getUser() ) );
        post.setType( basicPostDTO.getType() );
        post.setContent( basicPostDTO.getContent() );
        post.setEditedAt( basicPostDTO.getEditedAt() );
        post.setEditedUser( basicUserInfoDTOToUser( basicPostDTO.getEditedUser() ) );

        return post;
    }
}
