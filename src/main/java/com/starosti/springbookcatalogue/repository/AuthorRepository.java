package com.starosti.springbookcatalogue.repository;

import com.starosti.springbookcatalogue.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
