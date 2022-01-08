package com.bukvich.util.weatherstat.service;

import com.bukvich.util.weatherstat.dto.core.CityInfo;
import com.bukvich.util.weatherstat.dto.core.CityInput;
import com.bukvich.util.weatherstat.entity.City;
import com.bukvich.util.weatherstat.repository.CityRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;

    @Override
    @Transactional
    public CityInfo create(@NonNull CityInput input) {
        City city = City.builder()
                .publicId(input.publicId())
                .name(input.name())
                .country(input.country())
                .region(input.region())
                .build();

        return cityRepository.getById(cityRepository.saveAndFlush(city).getId(), CityInfo.class);
    }
}
