package com.bukvich.util.weatherstat.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.bukvich.util.weatherstat.AbstractDbTest;
import com.bukvich.util.weatherstat.dto.core.CityInfo;
import com.bukvich.util.weatherstat.dto.core.CityInput;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CityServiceImplTest extends AbstractDbTest {
  @Autowired CityService cityService;

  @Test
  void createCityShouldSetAllFields() {
    CityInput input =
        new CityInput(
            UUID.randomUUID(),
            UUID.randomUUID().toString(),
            UUID.randomUUID().toString(),
            UUID.randomUUID().toString());
    CityInfo actualCity = cityService.create(input);
    assertThat(actualCity).isNotNull();
    assertThat(actualCity.getId()).isNotNegative();
    assertThat(actualCity.getPublicId()).isEqualTo(input.publicId());
    assertThat(actualCity.getName()).isEqualTo(input.name());
    assertThat(actualCity.getCountry()).isEqualTo(input.country());
    assertThat(actualCity.getRegion()).isEqualTo(input.region());
  }

  @ParameterizedTest
  @ValueSource(ints = {1, 2, 3, 4, 5})
  void eachTestShouldHasCleanDbContext(int round) {
    CityInput input =
        new CityInput(
            UUID.randomUUID(),
            UUID.randomUUID().toString(),
            UUID.randomUUID().toString(),
            UUID.randomUUID().toString());
    CityInfo actualCity = cityService.create(input);
    assertThat(actualCity).isNotNull();
    assertThat(actualCity.getId()).isEqualTo(1);
  }

  @Test
  void getByIdShouldReturnExistedCity() {
    CityInput input =
        new CityInput(
            UUID.randomUUID(),
            UUID.randomUUID().toString(),
            UUID.randomUUID().toString(),
            UUID.randomUUID().toString());
    CityInfo existedCity = cityService.create(input);

    CityInfo actualCity = cityService.getById(existedCity.getId());

    assertThat(actualCity.getId()).isEqualTo(existedCity.getId());
  }
}
