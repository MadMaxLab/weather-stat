package com.bukvich.util.weatherstat.service;

import com.bukvich.util.weatherstat.dto.weather.api.HistoryDto;
import java.time.LocalDate;

public interface WeatherApiService {
  HistoryDto getCityHistory(String city, LocalDate date);
}
