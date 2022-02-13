package com.bukvich.util.weatherstat.entity;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("SameNameButDifferent")
public class HourForecast extends BaseEntity {
  private Integer cityId;

  private LocalDateTime localDateTime;

  private Float temp;

  private Float windSpeed;

  private Float humidity;

  private Float cloudRate;

  private Boolean willItRain;

  private Float chanceOfRain;

  private Boolean willItSnow;

  private Float chanceOfSnow;

  private Float gust;
  // TODO: Add wind direction
}
