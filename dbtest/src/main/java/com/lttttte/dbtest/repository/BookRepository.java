package com.lttttte.dbtest.repository;

import com.lttttte.dbtest.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
