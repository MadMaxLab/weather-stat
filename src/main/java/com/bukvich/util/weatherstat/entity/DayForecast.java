package com.bukvich.util.weatherstat.entity;

import java.time.LocalDate;
import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@SuppressWarnings("SameNameButDifferent")
public class DayForecast extends BaseEntity {
  private LocalDate date;

  private Integer cityId;

  private Float maxTemp;

  private Float minTemp;

  private Float avgTemp;

  private Float maxWind;

  private Float totalPrecipitation;

  private Float avgVision;

  private Float avgHumidity;
}
