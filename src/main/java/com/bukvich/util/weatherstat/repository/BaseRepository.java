package com.bukvich.util.weatherstat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T, I> extends JpaRepository<T, I> {
  <E> E getById(Integer id, Class<E> projection);
}
