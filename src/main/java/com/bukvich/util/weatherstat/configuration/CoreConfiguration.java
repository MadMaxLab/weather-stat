package com.bukvich.util.weatherstat.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(WeatherApiOptions.class)
public class CoreConfiguration {
  private final WeatherApiOptions weatherApiOptions;

  @Bean
  public WebClient configureWebClient() {
    return WebClient.builder().baseUrl(weatherApiOptions.getUrl()).build();
  }
}
