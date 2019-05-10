package com.lttttte.thymeleaftest03.repository;

import com.lttttte.thymeleaftest03.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.stream.Stream;

public interface PostRepository extends JpaRepository<Post,Long> {
    Stream<Post> findPostsByTitle(final String title);
}
