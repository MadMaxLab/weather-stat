package com.bukvich.util.weatherstat.dto.weather.api;

import com.fasterxml.jackson.annotation.JsonAlias;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;

@Data
public class ForecastDayDto {
  LocalDate date;
  DayDto day;
  @JsonAlias("hour")
  List<HourDto> hours;
}
