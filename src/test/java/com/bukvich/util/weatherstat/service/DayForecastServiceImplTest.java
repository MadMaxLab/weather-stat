package com.bukvich.util.weatherstat.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.byLessThan;

import com.bukvich.util.weatherstat.AbstractDbTest;
import com.bukvich.util.weatherstat.dto.core.CityInfo;
import com.bukvich.util.weatherstat.dto.core.CityInput;
import com.bukvich.util.weatherstat.dto.core.DayForecastInfo;
import com.bukvich.util.weatherstat.dto.core.DayForecastInput;
import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

@SpringBootTest
class DayForecastServiceImplTest extends AbstractDbTest {
  @Autowired private DayForecastService dayForecastService;

  @Autowired private CityService cityService;

  private static final Random RANDOM = new Random();

  @Test
  void createShouldSaveAllTheFields() {
    CityInfo existedCityInfo =
        cityService.create(
            new CityInput(
                UUID.randomUUID(),
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString(),
                UUID.randomUUID().toString()));
    DayForecastInput input =
        new DayForecastInput(
            UUID.randomUUID(),
            LocalDate.now(),
            existedCityInfo.getId(),
            RANDOM.nextFloat(),
            RANDOM.nextFloat(),
            RANDOM.nextFloat(),
            RANDOM.nextFloat(),
            RANDOM.nextFloat(),
            RANDOM.nextFloat(),
            RANDOM.nextFloat());
    DayForecastInfo actualInfo = dayForecastService.create(input);
    assertThat(actualInfo.getId()).isPositive();
    assertThat(actualInfo.getPublicId()).isEqualTo(input.publicId());
    assertThat(actualInfo.getDate()).isEqualTo(input.date());
    assertThat(actualInfo.getCityId()).isEqualTo(input.cityId());
    assertThat(actualInfo.getMaxTemp()).isEqualTo(input.maxTemp(), byLessThan(0.1f));
    assertThat(actualInfo.getMinTemp()).isEqualTo(input.minTemp(), byLessThan(0.1f));
    assertThat(actualInfo.getAvgTemp()).isEqualTo(input.avgTemp(), byLessThan(0.1f));
    assertThat(actualInfo.getMaxWind()).isEqualTo(input.maxWind(), byLessThan(0.1f));
    assertThat(actualInfo.getTotalPrecipitation())
        .isEqualTo(input.totalPrecipitation(), byLessThan(0.1f));
    assertThat(actualInfo.getAvgVision()).isEqualTo(input.avgVision(), byLessThan(0.1f));
    assertThat(actualInfo.getAvgHumidity()).isEqualTo(input.avgHumidity(), byLessThan(0.1f));
  }

  @Test
  void createWithNotExistedCityShouldThrow() {
    DayForecastInput input =
        DayForecastInput.builder()
            .publicId(UUID.randomUUID())
            .date(LocalDate.now())
            .cityId(Integer.MAX_VALUE)
            .build();

    assertThatThrownBy(() -> dayForecastService.create(input))
        .isInstanceOf(DataIntegrityViolationException.class)
        .hasMessageContaining("FK_day_forecast_city_id");
  }
}
