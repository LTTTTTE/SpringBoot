package com.lttttte.crudtest02.repository;

import com.lttttte.crudtest02.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Long> {
}
