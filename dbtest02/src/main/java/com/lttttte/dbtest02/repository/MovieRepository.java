package com.lttttte.dbtest02.repository;

import com.lttttte.dbtest02.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Long> {
}
