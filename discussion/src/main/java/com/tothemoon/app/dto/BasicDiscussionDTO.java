package com.tothemoon.app.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class BasicDiscussionDTO {
    private Long id;
    private String title;
    private Integer commentCount = 1;
    private Integer participantCount = 0;
    private Integer postNumberIndex = 0;
    private Date createdAt;
    private BasicUserInfoDTO user;
    private BasicUserInfoDTO lastPostedUser;
    private BasicPostDTO firstPost;
    private Date lastPostedAt;
    private BasicPostDTO lastPost;
    private Integer lastPostNumber;
    private List<BasicTagDTO> tags;
    private String slug;
    private Boolean isPrivate = false;
    private Boolean isApproved = true;
    private Boolean isSticky = false;
    private Boolean isLocked = false;
    private Boolean isPopular = false;
    private Integer viewCount = 0;
    private Integer votes;
}
