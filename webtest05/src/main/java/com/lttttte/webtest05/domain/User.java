package com.lttttte.webtest05.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Table
@Entity
public class User implements Serializable{

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String name;

    @Column
    private Integer age;

    @Builder
    public User(String name,Integer age){
        this.name = name;
        this.age = age;
    }
}
