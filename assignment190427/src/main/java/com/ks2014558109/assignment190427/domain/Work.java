package com.ks2014558109.assignment190427.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;


@Getter
@NoArgsConstructor
@Entity
@Table
public class Work implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idx;

    @Column
    private String company;

    @Column
    private String position;

    @Column
    private String webSite;

    @Column
    private LocalDate startDate;

    @Column
    private LocalDate endDate;

    @Column
    private String summary;

    @Builder
    public Work(String company, String position, String webSite, LocalDate startDate, LocalDate endDate, String summary) {
        this.company = company;
        this.position = position;
        this.webSite = webSite;
        this.startDate = startDate;
        this.endDate = endDate;
        this.summary = summary;
    }
}
