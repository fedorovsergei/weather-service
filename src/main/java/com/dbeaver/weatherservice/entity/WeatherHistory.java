package com.dbeaver.weatherservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "weather_date", unique = true)
    private LocalDate date;

    @Column(name = "weather_value")
    private String value;

    public WeatherHistory(LocalDate date, String value) {
        this.date = date;
        this.value = value;
    }
}
