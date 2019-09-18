package com.sangkon.model.user;

import java.time.Instant;

public class FollowRequest  {
    private Long id;
    private User follower;
    private User following;
    private Instant createdAt;
    private Instant updatedAt;
    private Long createdBy;
    private Long updatedBy;
}
