package com.lttttte.dbtest.domain;

import javax.persistence.*;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idx;

    private String name;

    @ManyToOne // Book 은 하나의 카테고리에만 존재할수있기에
    private Category category;

    public Long getIdx() {
        return idx;
    }

    public void setIdx(Long idx) {
        this.idx = idx;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {//중요
        //Java ORM 는 M:N을 만들어버린다 그래서
        //싱글톤스럽게 Book에는 하나의 카테고리만 연결(참조) 되도록 코드를 작성한다.
        // 이렇게할시 M:1 이되어서 M;N일때생기는 릴레이션 테이블이 안생겨서 2개의 테이블만보인다

        if(this.category != null){
           this.category.getBook().remove(this);
        }

        this.category = category;

        if(category != null){
            category.getBook().add(this);
        }
    }
}
