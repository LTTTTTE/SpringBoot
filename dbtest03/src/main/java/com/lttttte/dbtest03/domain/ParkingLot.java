package com.lttttte.dbtest03.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter @Setter @NoArgsConstructor
@Entity @Table
public class ParkingLot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idx;

    @Column
    private String name;

    @OneToMany(mappedBy = "parkingLot")
    private Set<Car> carSet = new LinkedHashSet<>();

    @Builder
    public ParkingLot(String name, Car car) {
        this.name = name;
        if(car != null){
            car.setParkingLot(this);
        }
    }
}
