package com.bukvich.util.weatherstat.repository;

import com.bukvich.util.weatherstat.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
    <T> T getById(Integer id, Class<T> projection);
}
