package com.lttttte.webtest04.repository;

import com.lttttte.webtest04.domain.MyTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyTableRepository extends JpaRepository<MyTable,Long> {
    MyTable findMyTableByContent(String content);
}
