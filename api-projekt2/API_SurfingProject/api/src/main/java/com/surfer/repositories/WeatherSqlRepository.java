package com.surfer.repositories;

import com.surfer.Entities.Weather;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherSqlRepository extends JpaRepository<Weather, Long> {

}
