package com.starosti.springbookcatalogue.dto;

import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

/**
 * A DTO for the {@link com.starosti.springbookcatalogue.entity.Genre} entity
 */
@Data
@Getter
public class GenreDto implements Serializable {
    private final Long id;
    private final String name;
}