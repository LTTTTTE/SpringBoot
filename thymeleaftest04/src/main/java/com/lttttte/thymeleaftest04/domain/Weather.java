package com.lttttte.thymeleaftest04.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor

@Entity
@Table
public class Weather implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    @Enumerated(EnumType.STRING)
    private WeatherType weatherType;

    @Column
    private Integer temperature;

    @Column
    private Integer dust;

    @Column
    private LocalDateTime createdDate;

    @Column
    private LocalDateTime updatedDate;

    @Builder

    public Weather(WeatherType weatherType, Integer temperature, Integer dust, LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.weatherType = weatherType;
        this.temperature = temperature;
        this.dust = dust;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }
}
