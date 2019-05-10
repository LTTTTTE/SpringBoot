package com.lttttte.webtest03.repository;

import com.lttttte.webtest03.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Long> {
}
