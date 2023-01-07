package com.bukvich.util.weatherstat.dto.core;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Builder;

@Builder
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
    Float gust) {}
