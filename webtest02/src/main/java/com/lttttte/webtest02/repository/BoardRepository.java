package com.lttttte.webtest02.repository;

import com.lttttte.webtest02.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Long> {
}
