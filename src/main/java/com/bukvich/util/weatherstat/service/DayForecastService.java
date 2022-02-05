package com.bukvich.util.weatherstat.service;

import com.bukvich.util.weatherstat.dto.core.DayForecastInfo;
import com.bukvich.util.weatherstat.dto.core.DayForecastInput;

public interface DayForecastService {
  DayForecastInfo create(DayForecastInput input);
}
