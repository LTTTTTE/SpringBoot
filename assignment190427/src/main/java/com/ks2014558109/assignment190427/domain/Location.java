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
public class Location implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idx;

    @Column
    private String address;

    @Column
    private String postCode;

    @Builder
    public Location(String address, String postCode) {
        this.address = address;
        this.postCode = postCode;
    }
}
