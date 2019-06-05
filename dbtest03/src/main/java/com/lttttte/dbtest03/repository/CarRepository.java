package com.lttttte.dbtest03.repository;

import com.lttttte.dbtest03.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Long> {
}
