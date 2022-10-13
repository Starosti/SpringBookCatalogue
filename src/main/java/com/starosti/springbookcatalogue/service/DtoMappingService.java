package com.starosti.springbookcatalogue.service;

import com.starosti.springbookcatalogue.dto.AuthorDto;
import com.starosti.springbookcatalogue.dto.BookDto;
import com.starosti.springbookcatalogue.dto.GenreDto;
import com.starosti.springbookcatalogue.entity.Author;
import com.starosti.springbookcatalogue.entity.Book;
import com.starosti.springbookcatalogue.entity.Genre;
import org.springframework.stereotype.Service;

@Service
public class DtoMappingService {

    public Author convertDtoToAuthor(AuthorDto dto){
        if (dto == null) return null;
        return Author.builder()
                .id(dto.getId())
                .name(dto.getName())
                .dateOfBirth(dto.getDateOfBirth())
                .build();
    }

    public Book convertDtoToBook(BookDto dto){
        if (dto == null) return null;
        return Book.builder()
                .id(dto.getId())
                .name(dto.getName())
                .length(dto.getLength())
                .author(this.convertDtoToAuthor(dto.getAuthor()))
                .genre(this.convertDtoToGenre(dto.getGenre()))
                .build();
    }

    public Genre convertDtoToGenre(GenreDto dto){
        if (dto == null) return null;
        return Genre.builder()
                .id(dto.getId())
                .name(dto.getName())
                .build();
    }
}
