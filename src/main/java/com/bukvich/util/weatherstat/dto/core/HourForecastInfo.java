package com.bukvich.util.weatherstat.dto.core;

import java.time.LocalDateTime;
import java.util.UUID;

public interface HourForecastInfo {
  Integer getId();

  UUID getPublicId();

  Integer getCityId();

  LocalDateTime getLocalDateTime();

  Float getTemp();

  Float getWindSpeed();

  Float getHumidity();

  Float getCloudRate();

  Boolean getWillItRain();

  Float getChanceOfRain();

  Boolean getWillItSnow();

  Float getChanceOfSnow();

  Float getGust();
}
