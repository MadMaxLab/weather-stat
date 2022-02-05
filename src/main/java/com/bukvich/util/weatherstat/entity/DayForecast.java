package com.bukvich.util.weatherstat.entity;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DayForecast {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private UUID publicId;

  private LocalDate date;

  private Integer cityId;

  private Float maxTemp;

  private Float minTemp;

  private Float avgTemp;

  private Float maxWind;

  private Float totalPrecipitation;

  private Float avgVision;

  private Float avgHumidity;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    DayForecast dayForecast = (DayForecast) o;
    return Objects.equals(publicId, dayForecast.publicId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(publicId);
  }
}
