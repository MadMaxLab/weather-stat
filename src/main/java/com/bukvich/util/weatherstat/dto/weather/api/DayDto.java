package com.bukvich.util.weatherstat.dto.weather.api;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class DayDto {
  @JsonAlias("maxtemp_c")
  private Float maxTemp;

  @JsonAlias("mintemp_c")
  private Float minTemp;

  @JsonAlias("avgtemp_c")
  private Float avgTemp;

  @JsonAlias("maxwind_kph")
  private Float maxWind;

  @JsonAlias("totalprecip_mm")
  private Float totalPrecipitation;

  @JsonAlias("avgvis_km")
  private Float avgVision;

  @JsonAlias("avghumidity")
  private Float avgHumidity;
}
