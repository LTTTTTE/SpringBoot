package com.ks2014558109.assignment190427.repository;

import com.ks2014558109.assignment190427.domain.Basic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.stream.Stream;

public interface BasicRepository  extends JpaRepository<Basic,Long> {

    Stream<Basic> findBasicsByName(String name);
}
