package com.bukvich.util.weatherstat.service;

import com.bukvich.util.weatherstat.dto.core.CityInfo;
import com.bukvich.util.weatherstat.dto.core.CityInput;

public interface CityService {
    CityInfo create(CityInput input);
}
