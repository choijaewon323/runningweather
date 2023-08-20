package com.jaewon.runningweather.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WeatherResponseDto {
    private String fcstTime;
    private String weather;

    public WeatherResponseDto(String fcstTime, String weather) {
        this.fcstTime = fcstTime;
        this.weather = weather;
    }
}
