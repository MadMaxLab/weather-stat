package com.bukvich.util.weatherstat.dto.weather.api;

import com.fasterxml.jackson.annotation.JsonAlias;
import java.util.List;
import lombok.Data;

@Data
public class ForecastDto {
  @JsonAlias("forecastday")
  List<ForecastDayDto> forecastDays;
}
