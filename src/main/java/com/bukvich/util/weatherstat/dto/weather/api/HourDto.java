package com.bukvich.util.weatherstat.dto.weather.api;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class HourDto {
  @JsonAlias("time")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
  private LocalDateTime localDateTime;
  @JsonAlias("temp_c")
  private Double temp;
  @JsonAlias("wind_kph")
  private Double windSpeed;
  private Double humidity;
  @JsonAlias("cloud")
  private Double cloudRate;
  @JsonAlias("will_it_rain")
  private Boolean willItRain;
  @JsonAlias("chance_of_rain")
  private Double chanceOfRain;
  @JsonAlias("will_it_snow")
  private Boolean willItSnow;
  @JsonAlias("chance_of_snow")
  private Double chanceOfSnow;
  @JsonAlias("gust_kph")
  private Double gust;

}
