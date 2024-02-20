package com.tothemoon.app.dto;

import com.tothemoon.common.entity.Post;
import lombok.*;

import java.util.Date;

@Data
public class DiscussionDTO {
    private Long id;
    private String title;
    private Integer commentCount = 1;
    private Integer participantCount = 0;
    private Integer postNumberIndex = 0;
    private Date createdAt;
    private BasicUserInfoDTO user;
    private Post firstPost;
    private Date lastPostedAt;
    private BasicUserInfoDTO lastPostedUser;
    private Post lastPost;
    private Integer lastPostNumber;
    private String slug;
    private Boolean isPrivate = false;
    private Boolean isApproved = true;
    private Boolean isSticky = false;
    private Boolean isLocked = false;
    private Boolean isPopular = false;
    private Integer viewCount = 0;
    private Integer votes;
}
