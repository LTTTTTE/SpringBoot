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
public class Profile implements Serializable {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String network;

    @Column
    private String userName;

    @Column
    private String url;

    @Column
    private LocalDateTime createdDate;

    @Column
    private LocalDateTime updatedDate;

    @Builder

    public Profile(String network, String userName, String url, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.network = network;
        this.userName = userName;
        this.url = url;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }
}
