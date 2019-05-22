package com.n20145588109.main.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Table
@Entity
public class Basic implements Serializable {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String name;

    @Column
    private String lable;

    @Column
    private String email;

    @Column
    private String phone;

    @Column
    private LocalDateTime createdDate;

    @Column
    private LocalDateTime updatedDate;

    @Builder
    public Basic(String name, String lable, String email, String phone, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.name = name;
        this.lable = lable;
        this.email = email;
        this.phone = phone;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }
}
