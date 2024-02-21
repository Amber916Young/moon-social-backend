package com.tothemoon.app.service;

import com.bird.exception.ErrorReasonCode;
import com.bird.exception.NotFoundRequestException;
import com.tothemoon.app.dto.BasicDiscussionDTO;
import com.tothemoon.app.dto.BasicTagDTO;
import com.tothemoon.app.dto.DiscussionDTO;
import com.tothemoon.app.mapper.DiscussionMapper;
import com.tothemoon.app.mapper.TagMapper;
import com.tothemoon.common.entity.Discussion;
import com.tothemoon.common.entity.DiscussionTag;
import com.tothemoon.common.entity.Post;
import com.tothemoon.common.entity.Tag;
import com.tothemoon.common.repository.DiscussionRepository;
import com.tothemoon.common.repository.DiscussionTagRepository;
import com.tothemoon.common.repository.PostRepository;
import com.tothemoon.common.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @ClassName:DiscussionService
 * @Auther: yyj
 * @Description:
 * @Date: 19/02/2024 19:42
 * @Version: v1.0
 */


@Service
@Transactional
@RequiredArgsConstructor
public class DiscussionService {

    private final DiscussionRepository discussionRepository;
    private final PostRepository postRepository;
    private final TagRepository tagRepository;
    private final DiscussionTagRepository discussionTagRepository;
    private final DiscussionMapper discussionMapper;
    private final TagMapper tagMapper;


    public Discussion getDiscussionWithComments(Long discussionId, Pageable pageable) {
        Discussion discussion = discussionRepository.findById(discussionId)
                .orElseThrow(() -> new NotFoundRequestException(ErrorReasonCode.Not_Found_Entity));

        List<Post> comments = postRepository.findByDiscussionId(discussionId, pageable);

//        DiscussionDetailDTO discussionDetailDTO = discussionMapper.toDetailDTO(discussion);
//
//        discussionDetailDTO.setPostList(comments);

        return discussion;
    }

    public Page<BasicDiscussionDTO>  getDiscussionList(Pageable pageable) {
        Page<Discussion> discussionPage = discussionRepository.findAll(pageable);

        List<Discussion> discussions = discussionPage.getContent();
        List<DiscussionDTO> discussionDTOs = discussionMapper.toDTOList(discussions);
        List<BasicDiscussionDTO> basicDiscussionDTOS = new ArrayList<>();
        // loop the  discussionDTOS get id , then find the tags from the  discussion_tag table
        // and based on the discussion_tag result to fetch the tags from tag table
        for (DiscussionDTO discussionDTO : discussionDTOs) {
            Long discussionId = discussionDTO.getId();
            List<DiscussionTag> discussionTags = discussionTagRepository.findByDiscussionId(discussionId);
            List<Tag> tagsForDiscussion = new ArrayList<>();
            for (DiscussionTag discussionTag : discussionTags) {
                tagsForDiscussion.add(discussionTag.getTag());
            }
            List<BasicTagDTO> basicTagDTOs = tagMapper.toBasicDTOList(tagsForDiscussion);
            BasicDiscussionDTO basicDiscussionDTO = new BasicDiscussionDTO();
            basicDiscussionDTO.setDiscussion(discussionDTO);
            basicDiscussionDTO.setTags(basicTagDTOs);
            basicDiscussionDTOS.add(basicDiscussionDTO);
        }
        return new PageImpl<>(basicDiscussionDTOS, pageable, discussionPage.getTotalElements());
    }
}
