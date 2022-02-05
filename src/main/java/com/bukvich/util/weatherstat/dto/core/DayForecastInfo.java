package com.bukvich.util.weatherstat.dto.core;

import java.time.LocalDate;
import java.util.UUID;

public interface DayForecastInfo {
  Integer getId();

  UUID getPublicId();

  LocalDate getDate();

  Integer getCityId();

  Float getMaxTemp();

  Float getMinTemp();

  Float getAvgTemp();

  Float getMaxWind();

  Float getTotalPrecipitation();

  Float getAvgVision();

  Float getAvgHumidity();
}
