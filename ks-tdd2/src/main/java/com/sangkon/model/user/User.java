package com.sangkon.model.user;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
public class User {
    private Long id;
    private String name;
    private String username;
    private String email;
    private boolean isPrivate;
    private String url;
    private String bio;
    private String sex;
    private String phone;
    private String imagePath;
    private Instant createdAt;
    private Instant updatedAt;
}
