package com.bukvich.util.weatherstat.dto.weather.api;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

@Data
public class DayDto {
  @JsonAlias("maxtemp_c")
  private Double maxTemp;
  @JsonAlias("mintemp_c")
  private Double minTemp;
  @JsonAlias("avgtemp_c")
  private Double avgTemp;
  @JsonAlias("maxwind_kph")
  private Double maxWind;
  @JsonAlias("totalprecip_mm")
  private Double totalPrecipitation;
  @JsonAlias("avgvis_km")
  private Double avgVision;
  @JsonAlias("avghumidity")
  private Double avgHumidity;
}
