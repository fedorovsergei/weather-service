package com.dbeaver.weatherservice.service;

import com.dbeaver.weatherservice.entity.WeatherHistory;
import com.dbeaver.weatherservice.repo.WeatherRepo;
import lombok.AllArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;

@Service
@AllArgsConstructor
public class WeatherService {

    private final WeatherRepo weatherRepo;

    @Cacheable("history")
    public WeatherHistory getTodayWeather() {
        LocalDate now = LocalDate.now();
        WeatherHistory weatherHistory = weatherRepo.findByDate(now);
        if (weatherHistory == null) {
            Document doc = null;
            try {
                doc = Jsoup.connect("https://yandex.ru").get();
                Elements weather = doc.getElementsByAttributeValue("class", "weather__temp");
                weatherHistory = weatherRepo.save(new WeatherHistory(now, weather.text()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return weatherHistory;
    }
}
