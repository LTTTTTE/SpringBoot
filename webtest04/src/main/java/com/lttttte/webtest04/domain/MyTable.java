package com.lttttte.webtest04.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.jboss.logging.LogMessage;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@NoArgsConstructor
@Entity
@Table
public class MyTable implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String title;

    @Column
    private String content;

    @Builder
    public MyTable(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
