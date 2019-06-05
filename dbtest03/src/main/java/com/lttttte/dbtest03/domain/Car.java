package com.lttttte.dbtest03.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Optional;

@Getter @Setter @NoArgsConstructor
@Entity @Table
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idx;

    @Column
    private String name;

    @ManyToOne
    private ParkingLot parkingLot;

    @Builder
    public Car(String name, ParkingLot parkingLot) {
        this.name = name;
        this.parkingLot = parkingLot;
        parkingLot.getCarSet().add(this);
    }

    public void setParkingLot(ParkingLot parkingLot){
        if(this.parkingLot != null){
            this.parkingLot.getCarSet().remove(this);
        }
        this.parkingLot = parkingLot;

        if(parkingLot != null){
            parkingLot.getCarSet().add(this);
        }
    }
}
