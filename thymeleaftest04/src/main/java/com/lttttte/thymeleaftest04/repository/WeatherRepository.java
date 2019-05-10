package com.lttttte.thymeleaftest04.repository;

import com.lttttte.thymeleaftest04.domain.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<Weather,Long> {

}
