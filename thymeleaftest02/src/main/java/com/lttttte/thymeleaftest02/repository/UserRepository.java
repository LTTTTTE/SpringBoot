package com.lttttte.thymeleaftest02.repository;

import com.lttttte.thymeleaftest02.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
