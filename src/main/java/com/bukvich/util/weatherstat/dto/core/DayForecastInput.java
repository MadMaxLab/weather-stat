package com.bukvich.util.weatherstat.dto.core;

import java.time.LocalDate;
import java.util.UUID;
import lombok.Builder;

@Builder
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
    float avgHumidity) {}
