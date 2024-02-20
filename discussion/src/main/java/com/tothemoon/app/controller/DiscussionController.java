package com.tothemoon.app.controller;

import com.tothemoon.app.dto.DiscussionDTO;
import com.tothemoon.app.mapper.DiscussionMapper;
import com.tothemoon.app.service.DiscussionService;
import com.tothemoon.common.entity.Discussion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName:DiscussionController
 * @Auther: yyj
 * @Description:
 * @Date: 19/02/2024 19:45
 * @Version: v1.0
 */
@RestController
@RequestMapping("/api/discussions")
public class DiscussionController {
    @Autowired
    private DiscussionService discussionService;

    private  DiscussionMapper discussionMapper;

    @GetMapping
    public ResponseEntity<List<DiscussionDTO>> getDiscussionList(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(discussionMapper.toDTOList(discussionService.getDiscussionList(pageable)));
    }

    @GetMapping("/{discussionId}")
    public ResponseEntity<Discussion> getDiscussionWithComments(
            @PathVariable Long discussionId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Discussion discussion = discussionService.getDiscussionWithComments(discussionId, pageable);

        return ResponseEntity.ok(discussion);
    }
}
