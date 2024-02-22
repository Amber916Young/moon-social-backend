package com.tothemoon.app.mapper;

import com.tothemoon.app.dto.BasicTagDTO;
import com.tothemoon.app.dto.TagDTO;
import com.tothemoon.common.entity.Tag;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-22T10:25:24+0000",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 1.8.0_352 (Amazon.com Inc.)"
)
@Component
public class TagMapperImpl implements TagMapper {

    @Override
    public TagDTO toDTO(Tag tag) {
        if ( tag == null ) {
            return null;
        }

        TagDTO tagDTO = new TagDTO();

        tagDTO.setId( tag.getId() );
        tagDTO.setName( tag.getName() );
        tagDTO.setSlug( tag.getSlug() );
        tagDTO.setDescription( tag.getDescription() );
        tagDTO.setColor( tag.getColor() );
        tagDTO.setPosition( tag.getPosition() );
        tagDTO.setParentTag( toDTO( tag.getParentTag() ) );
        tagDTO.setIsRestricted( tag.getIsRestricted() );
        tagDTO.setIsHidden( tag.getIsHidden() );
        tagDTO.setDiscussionCount( tag.getDiscussionCount() );
        tagDTO.setLastPostedAt( tag.getLastPostedAt() );
        tagDTO.setLastPostedDiscussion( tag.getLastPostedDiscussion() );
        tagDTO.setLastPostedUser( tag.getLastPostedUser() );
        tagDTO.setIcon( tag.getIcon() );
        tagDTO.setTemplate( tag.getTemplate() );
        tagDTO.setPassword( tag.getPassword() );
        tagDTO.setPostCount( tag.getPostCount() );
        tagDTO.setExcerptLength( tag.getExcerptLength() );
        tagDTO.setRichExcerpts( tag.getRichExcerpts() );

        return tagDTO;
    }

    @Override
    public Tag toEntity(TagDTO tagDTO) {
        if ( tagDTO == null ) {
            return null;
        }

        Tag tag = new Tag();

        tag.setId( tagDTO.getId() );
        tag.setName( tagDTO.getName() );
        tag.setSlug( tagDTO.getSlug() );
        tag.setDescription( tagDTO.getDescription() );
        tag.setColor( tagDTO.getColor() );
        tag.setPosition( tagDTO.getPosition() );
        tag.setParentTag( toEntity( tagDTO.getParentTag() ) );
        tag.setIsRestricted( tagDTO.getIsRestricted() );
        tag.setIsHidden( tagDTO.getIsHidden() );
        tag.setDiscussionCount( tagDTO.getDiscussionCount() );
        tag.setLastPostedAt( tagDTO.getLastPostedAt() );
        tag.setLastPostedDiscussion( tagDTO.getLastPostedDiscussion() );
        tag.setLastPostedUser( tagDTO.getLastPostedUser() );
        tag.setIcon( tagDTO.getIcon() );
        tag.setTemplate( tagDTO.getTemplate() );
        tag.setPassword( tagDTO.getPassword() );
        tag.setPostCount( tagDTO.getPostCount() );
        tag.setExcerptLength( tagDTO.getExcerptLength() );
        tag.setRichExcerpts( tagDTO.getRichExcerpts() );

        return tag;
    }

    @Override
    public List<TagDTO> toDTOList(List<Tag> tags) {
        if ( tags == null ) {
            return null;
        }

        List<TagDTO> list = new ArrayList<TagDTO>( tags.size() );
        for ( Tag tag : tags ) {
            list.add( toDTO( tag ) );
        }

        return list;
    }

    @Override
    public BasicTagDTO toBasicDTO(Tag tag) {
        if ( tag == null ) {
            return null;
        }

        BasicTagDTO basicTagDTO = new BasicTagDTO();

        basicTagDTO.setId( tag.getId() );
        basicTagDTO.setName( tag.getName() );
        basicTagDTO.setSlug( tag.getSlug() );
        basicTagDTO.setColor( tag.getColor() );
        basicTagDTO.setIcon( tag.getIcon() );

        return basicTagDTO;
    }

    @Override
    public List<BasicTagDTO> toBasicDTOList(List<Tag> tags) {
        if ( tags == null ) {
            return null;
        }

        List<BasicTagDTO> list = new ArrayList<BasicTagDTO>( tags.size() );
        for ( Tag tag : tags ) {
            list.add( toBasicDTO( tag ) );
        }

        return list;
    }
}
