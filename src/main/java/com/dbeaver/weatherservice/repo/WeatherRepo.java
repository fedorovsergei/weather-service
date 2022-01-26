package com.dbeaver.weatherservice.repo;

import com.dbeaver.weatherservice.entity.WeatherHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface WeatherRepo extends JpaRepository<WeatherHistory, Integer> {

    WeatherHistory findByDate(LocalDate now);
}