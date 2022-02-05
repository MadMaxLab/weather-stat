package com.bukvich.util.weatherstat.repository;

import com.bukvich.util.weatherstat.entity.DayForecast;
import org.springframework.stereotype.Repository;

@Repository
public interface DayForecastRepository extends BaseRepository<DayForecast, Integer> {}
