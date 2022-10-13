package com.starosti.springbookcatalogue.controller;

import com.starosti.springbookcatalogue.dto.GenreDto;
import com.starosti.springbookcatalogue.entity.Genre;
import com.starosti.springbookcatalogue.service.DtoMappingService;
import com.starosti.springbookcatalogue.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/genre")
public class GenreController {

    private final GenreService genreService;

    private final DtoMappingService dtoMappingService;

    @Autowired
    public GenreController(GenreService genreService, DtoMappingService dtoMappingService){
        this.genreService = genreService;
        this.dtoMappingService = dtoMappingService;
    }

    @GetMapping("/")
    public List<Genre> getGenre(){
        return genreService.getAllGenres();
    }

    @GetMapping("/{id}")
    public Genre getGenre(@PathVariable("id") Long id){
        return genreService.findGenreById(id);
    }

    @PostMapping("/")
    public Genre addGenre(@RequestBody GenreDto genre){
        return genreService.addGenre(dtoMappingService.convertDtoToGenre(genre));
    }

    @PutMapping("/")
    public Genre updateGenre(@RequestBody GenreDto genre){
        return genreService.updateGenre(dtoMappingService.convertDtoToGenre(genre));
    }

    @DeleteMapping("/{id}")
    public String deleteGenre(@PathVariable("id") Long id){
        if (genreService.removeGenreById(id)){
            return "Successfully removed!";
        }
        else {
            return "Couldn't find the genre!";
        }
    }
}
