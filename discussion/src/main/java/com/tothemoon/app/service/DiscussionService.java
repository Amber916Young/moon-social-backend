package com.tothemoon.app.service;

import com.bird.exception.ErrorReasonCode;
import com.bird.exception.NotFoundRequestException;
import com.tothemoon.app.dto.DiscussionDTO;
import com.tothemoon.app.dto.DiscussionDetailDTO;
import com.tothemoon.app.mapper.DiscussionMapper;
import com.tothemoon.common.entity.Discussion;
import com.tothemoon.common.entity.Post;
import com.tothemoon.common.repository.DiscussionRepository;
import com.tothemoon.common.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
@RequiredArgsConstructor
@Transactional
@Slf4j
public class DiscussionService {

    @Autowired
    private DiscussionRepository discussionRepository;
    @Autowired
    private PostRepository postRepository;

    private final DiscussionMapper discussionMapper;


    public Discussion getDiscussionWithComments(Long discussionId, Pageable pageable) {
        Discussion discussion = discussionRepository.findById(discussionId)
                .orElseThrow(() -> new NotFoundRequestException(ErrorReasonCode.Not_Found_Entity));

        List<Post> comments = postRepository.findByDiscussionId(discussionId, pageable);

        DiscussionDetailDTO discussionDetailDTO = discussionMapper.toDetailDTO(discussion);

        discussionDetailDTO.setPostList(comments);

        return discussion;
    }

    public List<Discussion> getDiscussionList(Pageable pageable) {
        return discussionRepository.findAll(pageable).getContent();
    }
}
