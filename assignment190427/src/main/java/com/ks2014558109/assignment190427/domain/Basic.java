package com.ks2014558109.assignment190427.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@NoArgsConstructor
@Entity
@Table
public class Basic implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idx;

    @Column
    private String name;

    @Column
    private String lable;

    @Column
    private String email;

    @Column
    private String phone;

    @Builder
    public Basic(String name, String lable, String email, String phone) {
        this.name = name;
        this.lable = lable;
        this.email = email;
        this.phone = phone;
    }
}
