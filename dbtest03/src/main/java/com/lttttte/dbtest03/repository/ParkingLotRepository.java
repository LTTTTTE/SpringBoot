package com.lttttte.dbtest03.repository;

import com.lttttte.dbtest03.domain.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingLotRepository extends JpaRepository<ParkingLot,Long> {
}
