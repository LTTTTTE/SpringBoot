package com.lttttte.crudtest.repository;

import com.lttttte.crudtest.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Long> {

}
