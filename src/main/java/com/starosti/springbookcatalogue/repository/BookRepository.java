package com.starosti.springbookcatalogue.repository;

import com.starosti.springbookcatalogue.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
