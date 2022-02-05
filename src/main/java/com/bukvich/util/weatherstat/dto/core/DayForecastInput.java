package com.bukvich.util.weatherstat.dto.core;

import java.time.LocalDate;
import java.util.UUID;
import lombok.Builder;

public record DayForecastInput(
    UUID publicId,
    LocalDate date,
    int cityId,
    float maxTemp,
    float minTemp,
    float avgTemp,
    float maxWind,
    float totalPrecipitation,
    float avgVision,
    float avgHumidity) {

  // Cause Intellij Idea bug https://youtrack.jetbrains.com/issue/IDEA-266513
  // TODO: delete me when Idea 2022.1 releases
  @Builder
  public DayForecastInput {}
}
