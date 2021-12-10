package com.bukvich.util.weatherstat.dto.weather.api;

import lombok.Data;

@Data
public class HistoryDto {
  LocationDto location;
  ForecastDto forecast;
}
