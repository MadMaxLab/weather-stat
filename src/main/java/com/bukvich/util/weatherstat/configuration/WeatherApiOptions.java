package com.bukvich.util.weatherstat.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "weather-api")
public class WeatherApiOptions {
  private String url;
  private String key;
}
