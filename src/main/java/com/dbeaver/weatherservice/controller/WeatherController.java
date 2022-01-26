package com.dbeaver.weatherservice.controller;

import com.dbeaver.weatherservice.entity.WeatherDto;
import com.dbeaver.weatherservice.entity.WeatherHistory;
import com.dbeaver.weatherservice.service.WeatherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.HttpURLConnection;

@RestController
@Api(tags = "Weather API")
@AllArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @ApiOperation("Получить информацию о сегодняшней погоде")
    @ApiResponses({
            @ApiResponse(code = HttpURLConnection.HTTP_OK, message = "OK", response = WeatherDto.class),
            @ApiResponse(code = HttpURLConnection.HTTP_BAD_REQUEST, message = "Bad request"),
    })
    @GetMapping("/weather")
    public ResponseEntity<WeatherDto> getTodayWeather() {
        WeatherHistory weatherHistory = weatherService.getTodayWeather();
        if (weatherHistory == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        WeatherDto weatherDto = new WeatherDto(weatherHistory.getDate(), weatherHistory.getValue());
        return new ResponseEntity<>(weatherDto, HttpStatus.OK);
    }
}