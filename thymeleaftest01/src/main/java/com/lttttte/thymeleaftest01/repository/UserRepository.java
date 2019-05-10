package com.lttttte.thymeleaftest01.repository;

import com.lttttte.thymeleaftest01.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
}
