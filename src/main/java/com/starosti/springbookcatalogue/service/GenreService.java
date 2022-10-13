package com.starosti.springbookcatalogue.service;

import com.starosti.springbookcatalogue.entity.Genre;
import com.starosti.springbookcatalogue.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
@RestController
public class GenreService {

    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository){
        this.genreRepository = genreRepository;
    }

    public Genre addGenre(Genre genre){
        return genreRepository.save(genre);
    }

    public Genre findGenreById(Long id){
        return genreRepository.findById(id).orElseThrow();
    }

    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    public Genre updateGenre(Genre genre){
        Genre updatedGenre = genreRepository.findById(genre.getId()).orElseThrow();
        if (genre.getName() != null){
            updatedGenre.setName(genre.getName());
        }
        return genreRepository.save(updatedGenre);
    }

    public boolean removeGenreById(Long id){
        boolean exists = genreRepository.existsById(id);
        genreRepository.deleteById(id);
        return exists;
    }
}
