package com.lttttte.dbtest02.domain;

import lombok.Builder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table
public class Studio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idx;

    @Column
    private String name;

    @Column
    private String owner;

    @OneToMany(mappedBy = "studio")
    private Set<Movie> movie = new HashSet<>();

    @Builder
    public Studio(String name, String owner, Set<Movie> movie) {
        this.name = name;
        this.owner = owner;
        this.movie = movie;
    }

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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Set<Movie> getMovie() {
        return movie;
    }

    public void setMovie(Set<Movie> movie) {
        this.movie = movie;
    }

    public Studio() {
    }
}
