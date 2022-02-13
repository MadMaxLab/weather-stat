package com.bukvich.util.weatherstat.dto.core;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Builder;

public record HourForecastInput(
    UUID publicId,
    Integer cityId,
    LocalDateTime localDateTime,
    Float temp,
    Float windSpeed,
    Float humidity,
    Float cloudRate,
    Boolean willItRain,
    Float chanceOfRain,
    Boolean willItSnow,
    Float chanceOfSnow,
    Float gust) {

  // Cause Intellij Idea bug https://youtrack.jetbrains.com/issue/IDEA-266513
  // TODO: delete me when Idea 2022.1 releases
  @Builder
  public HourForecastInput {}
}
