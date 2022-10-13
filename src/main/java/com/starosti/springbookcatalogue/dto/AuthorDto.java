package com.starosti.springbookcatalogue.dto;

import lombok.Data;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link com.starosti.springbookcatalogue.entity.Author} entity
 */
@Data
@Getter
public class AuthorDto implements Serializable {
    private final Long id;
    private final String name;
    private final LocalDate dateOfBirth;
}