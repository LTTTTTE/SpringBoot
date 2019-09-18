package com.sangkon.model.post;

import com.sangkon.model.user.User;
import java.time.Instant;
//TODO testcode
public class Comment {
    private Long id;
    private String body;
    private Post post;
    private User user;
    private Instant createdAt;
    private Instant updatedAt;
    private Long createdBy;
    private Long updatedBy;
}
