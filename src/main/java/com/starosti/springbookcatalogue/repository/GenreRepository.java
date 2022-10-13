package com.starosti.springbookcatalogue.repository;

import com.starosti.springbookcatalogue.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre,Long> {
}
