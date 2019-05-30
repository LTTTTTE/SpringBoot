package com.lttttte.dbtest.repository;

import com.lttttte.dbtest.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
