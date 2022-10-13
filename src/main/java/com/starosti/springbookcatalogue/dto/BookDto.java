package com.starosti.springbookcatalogue.dto;

import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

/**
 * A DTO for the {@link com.starosti.springbookcatalogue.entity.Book} entity
 */
@Data
@Getter
public class BookDto implements Serializable {
    private final Long id;
    private final String name;
    private final AuthorDto author;
    private final int length;
    private final GenreDto genre;
}