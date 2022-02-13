package com.bukvich.util.weatherstat.service;

import com.bukvich.util.weatherstat.dto.core.HourForecastInfo;
import com.bukvich.util.weatherstat.dto.core.HourForecastInput;

public interface HourForecastService {
  HourForecastInfo create(HourForecastInput input);
}
