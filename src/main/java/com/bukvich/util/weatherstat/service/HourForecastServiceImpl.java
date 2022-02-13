package com.bukvich.util.weatherstat.service;

import com.bukvich.util.weatherstat.dto.core.HourForecastInfo;
import com.bukvich.util.weatherstat.dto.core.HourForecastInput;
import com.bukvich.util.weatherstat.entity.HourForecast;
import com.bukvich.util.weatherstat.repository.HourForecastRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HourForecastServiceImpl implements HourForecastService {
  private final HourForecastRepository repository;

  @Override
  public HourForecastInfo create(HourForecastInput input) {
    HourForecast hourForecast =
        HourForecast.builder()
            .publicId(input.publicId())
            .cityId(input.cityId())
            .localDateTime(input.localDateTime())
            .temp(input.temp())
            .windSpeed(input.windSpeed())
            .humidity(input.humidity())
            .cloudRate(input.cloudRate())
            .willItRain(input.willItRain())
            .chanceOfRain(input.chanceOfRain())
            .willItSnow(input.willItSnow())
            .chanceOfSnow(input.chanceOfSnow())
            .gust(input.gust())
            .build();
    repository.saveAndFlush(hourForecast);
    return repository.getById(hourForecast.getId(), HourForecastInfo.class);
  }
}
