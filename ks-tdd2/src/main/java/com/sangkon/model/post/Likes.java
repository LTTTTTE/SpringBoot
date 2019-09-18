package com.sangkon.model.post;

import com.sangkon.model.user.User;

import java.time.Instant;

public class Likes {
    private Long id;
    private Post post;
    private User user;
    private Instant createdAt;
    private Instant updatedAt;
    private Long createdBy;
    private Long updatedBy;
}
