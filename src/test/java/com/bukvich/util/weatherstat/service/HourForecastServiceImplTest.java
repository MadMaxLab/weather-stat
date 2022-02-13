package com.bukvich.util.weatherstat.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.byLessThan;
import static org.junit.jupiter.api.Assertions.*;

import com.bukvich.util.weatherstat.AbstractDbTest;
import com.bukvich.util.weatherstat.dto.core.CityInfo;
import com.bukvich.util.weatherstat.dto.core.CityInput;
import com.bukvich.util.weatherstat.dto.core.HourForecastInfo;
import com.bukvich.util.weatherstat.dto.core.HourForecastInput;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HourForecastServiceImplTest extends AbstractDbTest {
  private static final Random RANDOM = new Random();

  @Autowired private HourForecastServiceImpl hourForecastService;

  @Autowired private CityService cityService;

  @Test
  void createHourForecastShouldSaveAllFields() {
    CityInfo existedCityInfo =
        cityService.create(
            new CityInput(
                UUID.randomUUID(),
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString()));

    HourForecastInput input =
        HourForecastInput.builder()
            .publicId(UUID.randomUUID())
            .cityId(existedCityInfo.getId())
            .localDateTime(LocalDateTime.now())
            .temp(RANDOM.nextFloat())
            .windSpeed(RANDOM.nextFloat())
            .humidity(RANDOM.nextFloat())
            .cloudRate(RANDOM.nextFloat())
            .willItRain(true)
            .chanceOfRain(RANDOM.nextFloat())
            .willItSnow(false)
            .chanceOfSnow(RANDOM.nextFloat())
            .gust(RANDOM.nextFloat())
            .build();

    HourForecastInfo actualInfo = hourForecastService.create(input);

    assertThat(actualInfo.getId()).isPositive();
    assertThat(actualInfo.getPublicId()).isNotNull();
    assertThat(actualInfo.getCityId()).isEqualTo(input.cityId());
    assertThat(actualInfo.getLocalDateTime()).isEqualTo(input.localDateTime());
    assertThat(actualInfo.getTemp()).isEqualTo(input.temp(), byLessThan(0.1f));
    assertThat(actualInfo.getWindSpeed()).isEqualTo(input.windSpeed(), byLessThan(0.1f));
    assertThat(actualInfo.getHumidity()).isEqualTo(input.humidity(), byLessThan(0.1f));
    assertThat(actualInfo.getCloudRate()).isEqualTo(input.cloudRate(), byLessThan(0.1f));
    assertThat(actualInfo.getWillItRain()).isEqualTo(input.willItRain());
    assertThat(actualInfo.getChanceOfRain()).isEqualTo(input.chanceOfRain(), byLessThan(0.1f));
    assertThat(actualInfo.getWillItSnow()).isEqualTo(input.willItSnow());
    assertThat(actualInfo.getChanceOfSnow()).isEqualTo(input.chanceOfSnow(), byLessThan(0.1f));
    assertThat(actualInfo.getGust()).isEqualTo(input.gust(), byLessThan(0.1f));
  }
}
