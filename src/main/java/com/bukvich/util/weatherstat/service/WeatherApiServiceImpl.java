package com.bukvich.util.weatherstat.service;

import com.bukvich.util.weatherstat.configuration.WeatherApiOptions;
import com.bukvich.util.weatherstat.dto.weather.api.HistoryDto;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class WeatherApiServiceImpl implements WeatherApiService {
  private final WeatherApiOptions weatherApiOptions;
  private final WebClient webClient;

  @Override
  public HistoryDto getCityHistory(String city, LocalDate date) {
    return webClient
        .post()
        .uri(
            uriBuilder ->
                uriBuilder
                    .queryParam("key", weatherApiOptions.getKey())
                    .queryParam("q", city)
                    .queryParam("dt", date)
                    .build())
        .retrieve()
        .onStatus(HttpStatus::isError, ClientResponse::createException)
        .bodyToMono(HistoryDto.class)
        .block();
  }
}
