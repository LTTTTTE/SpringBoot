package com.lttttte.webtest05.repository;

import com.lttttte.webtest05.domain.Board;
import com.lttttte.webtest05.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.Stream;

public interface UserRepository extends JpaRepository<User,Long> {

    Stream<User> findAllByName(String name);
}

