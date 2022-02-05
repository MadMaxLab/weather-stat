package com.bukvich.util.weatherstat.service;

import com.bukvich.util.weatherstat.dto.core.DayForecastInfo;
import com.bukvich.util.weatherstat.dto.core.DayForecastInput;
import com.bukvich.util.weatherstat.entity.DayForecast;
import com.bukvich.util.weatherstat.repository.DayForecastRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DayForecastServiceImpl implements DayForecastService {
  private final DayForecastRepository dayForecastRepository;

  @Override
  public DayForecastInfo create(DayForecastInput input) {
    DayForecast dayForecast =
        DayForecast.builder()
            .publicId(input.publicId())
            .date(input.date())
            .cityId(input.cityId())
            .maxTemp(input.maxTemp())
            .minTemp(input.minTemp())
            .avgTemp(input.avgTemp())
            .maxWind(input.maxWind())
            .totalPrecipitation(input.totalPrecipitation())
            .avgVision(input.avgVision())
            .avgHumidity(input.avgHumidity())
            .build();

    dayForecastRepository.save(dayForecast);

    return dayForecastRepository.getById(dayForecast.getId(), DayForecastInfo.class);
  }
}
