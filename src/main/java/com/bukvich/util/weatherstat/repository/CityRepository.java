package com.bukvich.util.weatherstat.repository;

import com.bukvich.util.weatherstat.entity.City;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends BaseRepository<City, Integer> {}
