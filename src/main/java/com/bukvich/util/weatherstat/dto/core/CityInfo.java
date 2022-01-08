package com.bukvich.util.weatherstat.dto.core;

import java.util.UUID;

public interface CityInfo {
    Integer getId();

    UUID getPublicId();

    String getName();

    String getRegion();

    String getCountry();
}
