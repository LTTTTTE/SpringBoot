package com.lttttte.dbtest02.domain;

import lombok.Builder;


import javax.persistence.*;
import java.time.LocalDateTime;


@Table
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idx;

    @Column
    private String title;

    @Column
    private LocalDateTime year;

    @Column
    private String studioName;

    @ManyToOne
    private Studio studio;


    @Builder
    public Movie(String title, LocalDateTime year, String studioName, Studio studio) {
        this.title = title;
        this.year = year;
        this.studioName = studioName;
        this.studio = studio;
    }

    public Long getIdx() {
        return idx;
    }

    public void setIdx(Long idx) {
        this.idx = idx;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getYear() {
        return year;
    }

    public void setYear(LocalDateTime year) {
        this.year = year;
    }

    public String getStudioName() {
        return studioName;
    }

    public void setStudioName(String studioName) {
        this.studioName = studioName;
    }

    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {

        if(this.studio != null){
            this.studio.getMovie().remove(this);
        }

        this.studio = studio;

        if(studio != null){
            studio.getMovie().add(this);
        }
    }

    public Movie() {
    }
}
